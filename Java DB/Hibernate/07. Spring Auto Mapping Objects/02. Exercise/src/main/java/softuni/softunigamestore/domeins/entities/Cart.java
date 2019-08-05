package softuni.softunigamestore.domeins.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;


@Getter @Setter
public class Cart {
    private List<Game> games;
    private User user;

    public Cart() {
        this.games = new ArrayList<>();
    }

    public String addItem(Game game){
        if (this.user.getGames().contains(game)){
            return "User already have that game.";
        }
        this.games.add(game);
        return game.getTitle() + " added to cart.";
    }

    public String removeItem(Game game){
        if (this.games.isEmpty()){
            return "The cart is empty.";
        }

        if (!this.games.contains(game)){
            return "The game isn't in shopping cart.";
        }
        this.games.remove(game);
        return game.getTitle() + " removed from cart.";
    }

    public String buyItems(){
        String lineSeparator = System.lineSeparator();
        StringBuilder sb = new StringBuilder();

        if (this.games.isEmpty()){
            return "The cart is empty.";
        }
        this.user.getGames().addAll(this.games);

        sb.append("Successfully bought games:").append(lineSeparator);
        for (Game game : this.games) {
            sb.append(" -").append(game.getTitle()).append(lineSeparator);
        }
        this.games.clear();
        return sb.toString();
    }
}
