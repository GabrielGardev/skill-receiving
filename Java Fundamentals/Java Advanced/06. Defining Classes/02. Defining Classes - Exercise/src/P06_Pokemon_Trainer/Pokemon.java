package P06_Pokemon_Trainer;

public class Pokemon {
    private String name;
    private String element;
    private int Health;

    public Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.Health = health;
    }

    public String getElement() {
        return element;
    }

    public void setHealth(int health) {
        this.Health -= health;
    }

    public int getHealth() {
        return Health;
    }
}
