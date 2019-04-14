package P03_Animals;

public class Animal {
    private String name;
    private String favoriteFood;

    public Animal(String name, String favouriteFood) {
        this.name = name;
        this.favoriteFood = favouriteFood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavouriteFood() {
        return favoriteFood;
    }

    public void setFavouriteFood(String favouriteFood) {
        this.favoriteFood = favouriteFood;
    }

    String explainSelf() {
        return String.format("I am %s and my favorite food is %s", this.name, this.favoriteFood);
    }

}
