package P03_Wild_Farm;

public class Tiger extends Felime {
    public Tiger(String name, String type, Double weight, String livingRegion) {
        super(name, type, weight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Meat")){
            this.setFoodEaten(food.getQuantity());
        }else {
            System.out.println("Tigers are not eating that type of food!");
        }
    }
}
