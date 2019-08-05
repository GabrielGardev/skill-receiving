package softuni.softunigamestore.service;

import softuni.softunigamestore.domeins.dtos.UserLoginDto;
import softuni.softunigamestore.domeins.dtos.UserRegisterDto;

public interface UserService {

    String registerUser(UserRegisterDto registerDto);

    String loginUser(UserLoginDto loginDto);

    String logoutUser();

    String getLoggedUserEmail();

    String addItem(String title);

    String removeItem(String titleOfGame);

    String buyItem();
}
