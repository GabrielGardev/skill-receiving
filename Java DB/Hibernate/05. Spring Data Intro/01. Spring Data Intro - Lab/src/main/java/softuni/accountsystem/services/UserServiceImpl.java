package softuni.accountsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import softuni.accountsystem.models.User;
import softuni.accountsystem.repositories.UserRepository;

@Service
@Primary
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(User user) {
        if (!userRepository.exists(Example.of(user))){
            userRepository.saveAndFlush(user);
        }
    }
}
