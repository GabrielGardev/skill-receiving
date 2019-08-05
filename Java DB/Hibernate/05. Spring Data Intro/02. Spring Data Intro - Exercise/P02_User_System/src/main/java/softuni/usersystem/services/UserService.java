package softuni.usersystem.services;

import softuni.usersystem.entities.User;

import java.io.IOException;
import java.util.List;

public interface UserService {
    void seedUsers() throws IOException;
    List<String> findAllUsersWithProvider(String provider);
    String findAllByLastLoginBeforeAndDeleteThem(String date);
}
