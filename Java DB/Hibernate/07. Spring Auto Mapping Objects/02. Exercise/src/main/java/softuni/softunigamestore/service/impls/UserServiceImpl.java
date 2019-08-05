package softuni.softunigamestore.service.impls;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.softunigamestore.domeins.dtos.UserLoginDto;
import softuni.softunigamestore.domeins.dtos.UserRegisterDto;
import softuni.softunigamestore.domeins.entities.Cart;
import softuni.softunigamestore.domeins.entities.Game;
import softuni.softunigamestore.domeins.entities.User;
import softuni.softunigamestore.domeins.enums.Role;
import softuni.softunigamestore.repositories.GameRepository;
import softuni.softunigamestore.repositories.UserRepository;
import softuni.softunigamestore.service.UserService;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final GameRepository gameRepository;
    private String loggedUserEmail;
    private Cart cart;

    @Autowired
    ModelMapper mapper;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, GameRepository gameRepository) {
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
        this.loggedUserEmail = "";
        this.cart = new Cart();
    }

    @Override
    public String registerUser(UserRegisterDto registerDto) {
        StringBuilder sb = new StringBuilder();

        if (!machPassword(registerDto.getPassword(), registerDto.getConfirmPassword())) {
            return sb.append("Passwords doesn't mach").toString();
        }

        User user = mapper.map(registerDto, User.class);

        User inDb = userRepository.findByEmail(user.getEmail()).orElse(null);
        if (inDb != null) {
            return sb.append("User is already registered.").toString();
        }

        Set<ConstraintViolation<User>> validate = validateUser(user);

        if (!validate.isEmpty()) {
            for (ConstraintViolation<User> violation : validate) {
                sb.append(violation.getMessage()).append(System.lineSeparator());
            }
        } else {
            if (userRepository.count() == 0) {
                user.setRole(Role.ADMIN);
            } else {
                user.setRole(Role.USER);
            }
            userRepository.saveAndFlush(user);
            sb.append(String.format("%s was registered", user.getFullName()));
        }

        return sb.toString();
    }

    @Override
    public String loginUser(UserLoginDto loginDto) {
        StringBuilder sb = new StringBuilder();

        if (isLogged()) {
           return sb.append("User is already logged in.").toString();
        }

        User user = userRepository.findByEmail(loginDto.getEmail()).orElse(null);

        if (user == null) {
            sb.append("Incorrect username / password");
        } else {
            if (!machPassword(user.getPassword(), loginDto.getPassword())) {
                sb.append("Incorrect password!");
            } else {
                loggedUserEmail = user.getEmail();
                sb.append(String.format("Successfully logged in %s",
                        user.getFullName()));
            }
        }
        return sb.toString();
    }

    @Override
    public String logoutUser() {
        StringBuilder sb = new StringBuilder();

        if (isLogged()){
            User user = userRepository.findByEmail(loggedUserEmail).get();
            loggedUserEmail = "";
            sb.append(String.format("User %s successfully logged out",
                    user.getFullName()));
        }else {
            sb.append("Cannot log out. No user was logged in.");
        }

        return sb.toString();
    }

    @Override
    public String addItem(String title) {
        User user = this.getUser();

        if (user == null){
            return "No logged user";
        }
        this.cart.setUser(user);

        Game game = this.gameRepository.findByTitle(title).orElse(null);

        if (game == null){
            return "Game doesn't exist";
        }

       return this.cart.addItem(game);
    }

    @Override
    public String removeItem(String titleOfGame) {
        User user = this.getUser();

        if (user == null){
            return "No logged user";
        }

        Game game = this.gameRepository.findByTitle(titleOfGame).orElse(null);

        if (game == null){
            return "Game doesn't exist";
        }

        return this.cart.removeItem(game);
    }

    @Override
    public String buyItem() {
        User user = this.getUser();

        if (user == null){
            return "No logged user";
        }

        String result = this.cart.buyItems();
        this.userRepository.saveAndFlush(this.cart.getUser());

        return result;
    }

    private User getUser() {
        return this.userRepository.findByEmail(loggedUserEmail).orElse(null);
    }

    @Override
    public String getLoggedUserEmail() {
        return this.loggedUserEmail;
    }

    private boolean isLogged() {
        return !loggedUserEmail.isEmpty();
    }

    private boolean machPassword(String password, String secondPassword) {
        return password.equals(secondPassword);
    }

    private Set<ConstraintViolation<User>> validateUser(User user) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        return validator.validate(user);
    }
}
