package P06_Pokemon_Trainer;

import java.util.ArrayList;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private ArrayList<Pokemon> pokemons;

    public Trainer(String name, ArrayList<Pokemon> pokemons) {
        this.name = name;
        this.numberOfBadges = 0;
        this.pokemons = pokemons;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setNumberOfBadges(int numberOfBadges) {
        this.numberOfBadges += numberOfBadges;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }
}
