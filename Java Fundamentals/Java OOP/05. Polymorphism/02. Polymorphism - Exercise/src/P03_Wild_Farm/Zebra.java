package P03_Wild_Farm;

public class Zebra extends Mammal {
    public Zebra(String name, String type, Double weight, String livingRegion) {
        super(name, type, weight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Vegetable")){
            this.setFoodEaten(food.getQuantity());
        }else {
            System.out.println("Zebras are not eating that type of food!");
        }
    }
}
