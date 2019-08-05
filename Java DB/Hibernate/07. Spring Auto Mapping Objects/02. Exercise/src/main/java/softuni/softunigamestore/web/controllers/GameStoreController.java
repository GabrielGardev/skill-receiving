package softuni.softunigamestore.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import softuni.softunigamestore.domeins.dtos.AddGameDto;
import softuni.softunigamestore.domeins.dtos.UserLoginDto;
import softuni.softunigamestore.domeins.dtos.UserRegisterDto;
import softuni.softunigamestore.service.GameService;
import softuni.softunigamestore.service.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Controller
public class GameStoreController implements CommandLineRunner {

    private final UserService userService;
    private final GameService gameService;
    private BufferedReader reader;

    @Autowired
    public GameStoreController(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {

        while (true){
            String line = reader.readLine();
            if (line.equals("exit")){
                break;
            }

            String[] param = line.split("\\|");
            switch (param[0]){
                case "RegisterUser":
                    UserRegisterDto user = new UserRegisterDto(param[1], param[2], param[3], param[4]);
                    System.out.println(this.userService.registerUser(user));
                    break;
                case "LoginUser":
                    UserLoginDto loginUser = new UserLoginDto(param[1], param[2]);
                    System.out.println(this.userService.loginUser(loginUser));
                    this.gameService.setLoggedUser(this.userService.getLoggedUserEmail());
                    break;
                case "Logout":
                    System.out.println(this.userService.logoutUser());
                    this.gameService.setLoggedUser(this.userService.getLoggedUserEmail());
                    break;
                case "AddGame":
                    AddGameDto addGameDto = new AddGameDto(
                            param[1],
                            BigDecimal.valueOf(Double.parseDouble(param[2])),
                            Double.parseDouble(param[3]),
                            param[4],
                            param[5],
                            param[6],
                            LocalDate.parse(param[7], DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                    System.out.println(this.gameService.addGame(addGameDto));
                    break;
                case "EditGame":
                    int id = Integer.parseInt(param[1]);
                    String[] newArray = Arrays.copyOfRange(param, 2, param.length);
                    System.out.println(this.gameService.editGame(id, newArray));
                    break;
                case "DeleteGame":
                    int idForDeletion = Integer.parseInt(param[1]);
                    System.out.println(this.gameService.deleteGameById(idForDeletion));
                    break;
                case "AllGames":
                    for (String game : this.gameService.allGames()) {
                        System.out.println(game);
                    }
                    break;
                case "DetailGame":
                    System.out.println(this.gameService.detailGame(param[1]));
                    break;
                case "OwnedGames":
                    for (String title : this.gameService.getGamesOfLoggedUser()) {
                        System.out.println(title);
                    }
                    break;
                case "AddItem":
                    String title = param[1];
                    System.out.println(this.userService.addItem(title));
                    break;
                case "RemoveItem":
                    String titleOfGame = param[1];
                    System.out.println(this.userService.removeItem(titleOfGame));
                    break;
                case "BuyItem":
                    System.out.println(this.userService.buyItem());
                    break;
            }
        }
    }
}
