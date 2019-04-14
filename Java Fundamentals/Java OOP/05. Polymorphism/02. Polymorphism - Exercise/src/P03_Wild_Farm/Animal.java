package P03_Wild_Farm;

import java.text.DecimalFormat;

public abstract class Animal implements AnimalOptions {
    private String name;
    private String type;
    private Double weight;
    private Integer foodEaten;

    public Animal(String name, String type, Double weight) {
        this.name = name;
        this.type = type;
        this.weight = weight;
        this.foodEaten = 0;
    }

    public void setFoodEaten(Integer foodEaten) {
        this.foodEaten += foodEaten;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Double getWeight() {
        return weight;
    }

    public Integer getFoodEaten() {
        return foodEaten;
    }
}
