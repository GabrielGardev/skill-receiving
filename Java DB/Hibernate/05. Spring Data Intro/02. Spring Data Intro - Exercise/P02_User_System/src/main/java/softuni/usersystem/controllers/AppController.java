package softuni.usersystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import softuni.usersystem.services.CountryService;
import softuni.usersystem.services.TownService;
import softuni.usersystem.services.UserService;

import java.util.List;

@Controller
public class AppController implements CommandLineRunner {

    private final CountryService countryService;
    private final TownService townService;
    private final UserService userService;

    @Autowired
    public AppController(CountryService countryService, TownService townService, UserService userService) {
        this.countryService = countryService;
        this.townService = townService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.countryService.seedCountries();
        this.townService.seedTowns();
        this.userService.seedUsers();

        //Get Users by Email Provider
//        String domain = "gmail.com";
//        getUsersWithGivenDomain(domain);

        //Remove Inactive Users
//        String date = "12 Oct 2015";
//        deleteUsersBefore(date);
    }

    private void deleteUsersBefore(String date) {
        System.out.println(this.userService.findAllByLastLoginBeforeAndDeleteThem(date));
    }

    private void getUsersWithGivenDomain(String domain) {
        List<String> list = this.userService.findAllUsersWithProvider(domain);

        if (list.isEmpty()){
            System.out.println("No users found with email domain " + domain);
        }
        for (String users : list) {
            System.out.println(users);
        }
    }
}
