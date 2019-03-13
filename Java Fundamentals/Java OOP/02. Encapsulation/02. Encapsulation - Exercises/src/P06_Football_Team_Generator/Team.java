package P06_Football_Team_Generator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.trim().isEmpty()){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public void removePlayer(String name){
        for (Player player : this.players) {
            if (player.getName().equals(name)){
                this.players.remove(player);
                return;
            }
        }
        throw new IllegalArgumentException(String.format("Player %s is not in %s team.", name, this.name));
    }

    public double getRating(){
       return this.players.stream().mapToDouble(Player::overallSkillLevel).average().orElse(0.0);
    }
}
