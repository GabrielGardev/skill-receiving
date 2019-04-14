package P03_Animals;

public class Dog extends Animal {
    public Dog(String name, String favoriteFood) {
        super(name, favoriteFood);
    }

    @Override
    String explainSelf() {
        return String.format("I am %s and my favorite food is %s%nDJAAF",
                super.getName(), super.getFavouriteFood());
    }
}
