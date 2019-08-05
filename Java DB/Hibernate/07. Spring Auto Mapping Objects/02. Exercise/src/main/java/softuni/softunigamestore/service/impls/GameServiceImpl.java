package softuni.softunigamestore.service.impls;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.softunigamestore.domeins.dtos.AddGameDto;
import softuni.softunigamestore.domeins.dtos.GameLongDto;
import softuni.softunigamestore.domeins.dtos.GameShortDto;
import softuni.softunigamestore.domeins.entities.Game;
import softuni.softunigamestore.domeins.entities.User;
import softuni.softunigamestore.domeins.enums.Role;
import softuni.softunigamestore.repositories.GameRepository;
import softuni.softunigamestore.repositories.UserRepository;
import softuni.softunigamestore.service.GameService;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final UserRepository userRepository;
    private String loggedUserEmail;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository, UserRepository userRepository) {
        this.gameRepository = gameRepository;
        this.userRepository = userRepository;
        this.loggedUserEmail = "";
    }

    @Override
    public String addGame(AddGameDto addGameDto) {
        StringBuilder sb = new StringBuilder();

        Game game = mapper.map(addGameDto, Game.class);

        if (checkViolations(sb, game)) return sb.toString();

        User user = this.getUser();

        if (user == null){
            return "No logged user";
        }

        if (user.getRole() != Role.ADMIN){
           sb.append(String.format("%s is not admin", user.getFullName()));
        }else {
            if (isGameExist(game)) {
                return sb.append("Game already exists!").toString();
            }
            this.gameRepository.saveAndFlush(game);
            sb.append(String.format("Added %s", game.getTitle()));
        }

        return sb.toString();
    }

    private User getUser() {
        return this.userRepository.findByEmail(loggedUserEmail).orElse(null);
    }

    @Override
    public String editGame(int id, String[] values) {
        StringBuilder sb = new StringBuilder();

        User user = this.getUser();

        if (user == null){
            return "No logged user";
        }

        Game game = this.gameRepository.findById(id).orElse(null);

        if (game == null){
            return "Game doesn't exist";
        }

        for (String value : values) {
            this.editField(game, value);
        }

        if (checkViolations(sb, game)) return sb.toString();
        this.gameRepository.saveAndFlush(game);

        return sb.append("Edited ").append(game.getTitle()).toString();
    }

    @Override
    public String deleteGameById(int id) {
        User user = this.getUser();

        if (user == null){
            return "No logged user";
        }

        Game game = this.gameRepository.findById(id).orElse(null);

        if (game == null){
            return "Game doesn't exist";
        }

        this.gameRepository.deleteById(id);

        return String.format("Deleted %s", game.getTitle());
    }

    @Override
    public List<String> allGames() {
        List<GameShortDto> listOfGames = this.gameRepository.findAll()
                .stream()
                .map(g -> mapper.map(g, GameShortDto.class))
                .collect(Collectors.toList());

        return listOfGames
                .stream()
                .map(g -> String.format("%s %.2f",
                        g.getTitle(),
                        g.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public String detailGame(String title) {
        Game game = this.gameRepository.findByTitle(title).orElse(null);

        if (game == null){
            return "Game doesn't exist";
        }

        GameLongDto longDto = mapper.map(game, GameLongDto.class);

        return String.format("Title: %s\n" +
                "Price: %.2f\n" +
                "Description: %s\n" +
                "Release date: %s\n",
                longDto.getTitle(),
                longDto.getPrice(),
                longDto.getDescription(),
                longDto.getReleaseDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }

    @Override
    public List<String> getGamesOfLoggedUser() {
        List<String> resultList = new ArrayList<>();

        User user = this.getUser();

        if (user == null){
            resultList.add("No logged user");
            return resultList;
        }

        for (Game game : user.getGames()) {
            resultList.add(game.getTitle());
        }

        return resultList;
    }

    private boolean checkViolations(StringBuilder sb, Game game) {
        Set<ConstraintViolation<Game>> constraintViolations = validateGame(game);

        if (!constraintViolations.isEmpty()) {
            for (ConstraintViolation<Game> violation : constraintViolations) {
                sb.append(violation.getMessage()).append(System.lineSeparator());
            }
            return true;
        }
        return false;
    }

    private void editField(Game game, String input) {
        String[] values = input.split("=");
        String name = values[0];
        String value = values[1];

        switch (name){
            case "description":
                game.setDescription(value);
                break;
            case "title":
                game.setTitle(value);
                break;
            case "size":
                game.setSize(Double.parseDouble(value));
                break;
            case "price":
                game.setPrice(BigDecimal.valueOf(Double.parseDouble(value)));
                break;
            case "trailer":
                game.setTrailer(value);
                break;
            case "thumbnail":
                game.setThumbnail(value);
                break;
        }
    }

    private Set<ConstraintViolation<Game>> validateGame(Game game) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        return validator.validate(game);
    }

    @Override
    public boolean isGameExist(Game game) {
        Game game1 = this.gameRepository.findByTitle(game.getTitle()).orElse(null);
        return game1 != null;
    }

    @Override
    public void setLoggedUser(String email) {
        this.loggedUserEmail = email;
    }
}
