package P05_Pizza_Calories;

public class Topping {
    private static final double MEAT = 1.2;
    private static final double VEGGIES = 0.8;
    private static final double CHEESE = 1.1;
    private static final double SAUCE = 0.9;

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (toppingType.equals("Meat") || toppingType.equals("Veggies") || toppingType.equals("Cheese") || toppingType.equals("Sauce")){
            this.toppingType = toppingType;
            return;
        }
        throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
    }

    private void setWeight(double weight) {
        //possible error in the name of product
        if (weight < 1 || weight > 50){
            throw new IllegalArgumentException(this.toppingType + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    public double calculateCalories(){
        double calories =  (2 * this.weight) * getToppingCal();
        return calories;
    }

    private double getToppingCal() {
        double toppingCal = 0;
        switch (this.toppingType){
            case "Meat":
                toppingCal = Topping.MEAT;
                break;
            case "Veggies":
                toppingCal = Topping.VEGGIES;
                break;
            case "Cheese":
                toppingCal = Topping.CHEESE;
                break;
            case "Sauce":
                toppingCal = Topping.SAUCE;
                break;
        }
        return toppingCal;
    }
}
