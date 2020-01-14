package metube.service;

import metube.domain.entities.User;
import metube.domain.models.service.UserServiceModel;
import metube.repository.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Inject
    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public boolean registerUser(UserServiceModel userServiceModel) {
        User user = mapper.map(userServiceModel, User.class);
        user.setPassword(DigestUtils.sha256Hex(userServiceModel.getPassword()));

        try {
            userRepository.save(user);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean loginUser(UserServiceModel userServiceModel) {
        User user = userRepository
                .findByUsernameAndPassword(userServiceModel.getUsername(),
                        DigestUtils.sha256Hex(userServiceModel.getPassword()));

        return user != null;
    }

    @Override
    public UserServiceModel findUserByUsername(String username) {
        User user = userRepository.findByUsername(username);

        if (user == null){
            throw new IllegalArgumentException();
        }

        return mapper.map(user, UserServiceModel.class);
    }
}
