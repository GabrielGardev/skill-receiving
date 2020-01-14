package casebook.service;

import casebook.domain.models.service.UserServiceModel;

import java.util.List;

public interface UserService {

    boolean registerUser(UserServiceModel userServiceModel);

    UserServiceModel loginUser(UserServiceModel userServiceModel);

    UserServiceModel getUserById(String id);

    List<UserServiceModel> getAllUsers();

    boolean addFriend(UserServiceModel userServiceModel);
}
