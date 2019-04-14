package hell.entities.heroes;

import hell.entities.miscellaneous.HeroInventory;
import hell.interfaces.Hero;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

abstract class HeroImpl implements Hero {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int hitPoints;
    private int damage;
    private Inventory inventory;

    HeroImpl(String name, int strength, int agility, int intelligence, int hitPoints, int damage) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.hitPoints = hitPoints;
        this.damage = damage;
        this.inventory = new HeroInventory();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public long getStrength() {
        return this.strength + this.inventory.getTotalStrengthBonus();
    }

    @Override
    public long getAgility() {
        return this.agility + this.inventory.getTotalAgilityBonus();
    }

    @Override
    public long getIntelligence() {
        return this.intelligence + this.inventory.getTotalIntelligenceBonus();
    }

    @Override
    public long getHitPoints() {
        return this.hitPoints + this.inventory.getTotalHitPointsBonus();
    }

    @Override
    public long getDamage() {
        return this.damage + this.inventory.getTotalDamageBonus();
    }

    @Override
    public Collection<Item> getItems() {
        try {
            Field commonItems = this.inventory.getClass().getDeclaredField("commonItems");
            commonItems.setAccessible(true);
            return ((Map<String, Item>) commonItems.get(this.inventory)).values();
        } catch (NoSuchFieldException | IllegalAccessException ignored) {
        }

        return null;
    }

    @Override
    public void addItem(Item item) {
        this.inventory.addCommonItem(item);
    }

    @Override
    public void addRecipe(Recipe recipe) {
        this.inventory.addRecipeItem(recipe);
    }

    @Override
    public String toString() {
        String items = this.getItems().isEmpty() ? "None" : System.lineSeparator() + this.getItems().toString();
        items = items.replaceAll("[\\[\\]]", "");
        return String.format("Hero: %s, Class: %s\n" +
                "HitPoints: %d, Damage: %d\n" +
                "Strength: %d\n" +
                "Agility: %d\n" +
                "Intelligence: %d\n" +
                "Items: %s", this.getName(), this.getClass().getSimpleName(),
                this.getHitPoints(),
                this.getDamage(),
                this.getStrength(),
                this.getAgility(),
                this.getIntelligence(),
                items);
    }
}
