package softuni.softunigamestore.service;

import softuni.softunigamestore.domeins.dtos.AddGameDto;
import softuni.softunigamestore.domeins.entities.Game;

import java.util.List;

public interface GameService {

    String addGame(AddGameDto addGameDto);

    void setLoggedUser(String email);

    boolean isGameExist(Game game);

    String editGame(int id, String[] values);

    String deleteGameById(int id);

    List<String> allGames();

    String detailGame(String title);

    List<String> getGamesOfLoggedUser();
}
