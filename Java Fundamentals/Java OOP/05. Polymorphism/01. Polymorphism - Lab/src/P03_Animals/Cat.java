package P03_Animals;

public class Cat extends Animal {
    public Cat(String name, String favoriteFood) {
        super(name, favoriteFood);
    }

    @Override
     String explainSelf() {
        return String.format("I am %s and my favorite food is %s%nMEEOW",
                super.getName(), super.getFavouriteFood());

    }
}
