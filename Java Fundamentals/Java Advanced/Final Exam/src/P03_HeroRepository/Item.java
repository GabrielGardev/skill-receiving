package P03_HeroRepository;

public class Item {
    private int strength;
    private int agility;
    private int intelligence;

    public Item(int strength, int agility, int intelligence) {
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    @Override
    public String toString() {
//Item:
//  * Strength: 23
//  * Agility: 35
//  * Intelligence: 48

        return String.format("Item:%n" +
                "  * Strength: %d%n" +
                "  * Agility: %d%n" +
                "  * Intelligence: %d", this.getStrength(), this.getAgility(), this.getIntelligence());
    }
}
