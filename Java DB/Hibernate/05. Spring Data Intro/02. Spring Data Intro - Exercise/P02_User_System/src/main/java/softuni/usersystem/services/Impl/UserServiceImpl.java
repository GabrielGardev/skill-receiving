package softuni.usersystem.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.usersystem.entities.Town;
import softuni.usersystem.entities.User;
import softuni.usersystem.repositories.TownRepository;
import softuni.usersystem.repositories.UserRepository;
import softuni.usersystem.services.UserService;
import softuni.usersystem.utils.FileUtil;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    //Dont forgot to change the @PATH when you test
    private static final String USERS_PATH = "C:\\Users\\Freeware Sys\\Projects\\Java DB\\Hibernate\\05. Spring Data Intro\\" +
            "02. Spring Data Intro - Exercise\\P02_User_System\\src\\main\\resources\\files\\users";

    private final UserRepository userRepository;
    private final TownRepository townRepository;
    private final FileUtil fileUtil;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, TownRepository townRepository, FileUtil fileUtil) {
        this.userRepository = userRepository;
        this.townRepository = townRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedUsers() throws IOException {
        if (this.userRepository.count() > 0){
            return;
        }

        for (String[] strings : this.fileUtil.fileContent(USERS_PATH)) {
            User user = new User();
            user.setAge(Integer.parseInt(strings[0]));
            user.setEmail(strings[1]);
            user.setFirstName(strings[2]);
            user.setLastName(strings[3]);
            user.setDeleted(Boolean.valueOf(strings[4]));

            LocalDate lastTimeLogged = LocalDate.parse(strings[5]);
            user.setLastLogin(lastTimeLogged);
            user.setPassword(strings[6]);

            LocalDate regOn = LocalDate.parse(strings[7]);
            user.setRegisteredOn(regOn);
            user.setUserName(strings[8]);

            Town bornTown = this.townRepository.getOne(Integer.parseInt(strings[9]));
            user.setBornTown(bornTown);

            Town currentTown = this.townRepository.getOne(Integer.parseInt(strings[10]));
            user.setCurrentlyLivingTown(currentTown);

            this.userRepository.saveAndFlush(user);
        }
    }

    @Override
    public List<String> findAllUsersWithProvider(String provider) {
        return this.userRepository.findAllByEmailEndsWith(provider)
                .stream()
                .map(u -> String.format("%s %s",
                        u.getUserName(),
                        u.getEmail()))
                .collect(Collectors.toList());
    }

    @Override
    public String findAllByLastLoginBeforeAndDeleteThem(String date) {
        String pattern = "dd MMM yyyy";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        LocalDate localDate = LocalDate.parse(date, dateTimeFormatter);
        List<User> list = this.userRepository.findAllByLastLoginBefore(localDate);
        int userCount = list.size();

        this.userRepository.deleteAll(list);

        return userCount > 0
                ? String.format("%d users have been deleted",
                    userCount)
                : "No users have been deleted";
    }


}
