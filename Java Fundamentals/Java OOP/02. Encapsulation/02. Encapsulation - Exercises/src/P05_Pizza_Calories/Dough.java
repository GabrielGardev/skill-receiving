package P05_Pizza_Calories;

public class Dough {
    private static final double WHITE = 1.5;
    private static final double WHOLEGRAIN = 1;
    private static final double CRISPY = 0.9;
    private static final double CHEWY = 1.1;
    private static final double HOMEMADE = 1;

    private double weight;
    private String flourType;
    private String bakingTechnique;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    public Dough() {
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200){
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    private void setFlourType(String flourType) {
        if (flourType.equals("White") || flourType.equals("Wholegrain")) {
            this.flourType = flourType;
            return;
        }
        throw new IllegalArgumentException("Invalid type of dough.");
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (bakingTechnique.equals("Crispy") || bakingTechnique.equals("Chewy") || bakingTechnique.equals("Homemade")) {
            this.bakingTechnique = bakingTechnique;
            return;
        }
        throw new IllegalArgumentException("Invalid type of dough.");
    }

    public double calculateCalories(){
        double calories = (this.weight * 2) * getFlourCalories() * getTechniqueCal();
        return calories;
    }

    private double getTechniqueCal() {
        double techniqueCal = 0;

        switch (this.bakingTechnique){
            case "Crispy":
                techniqueCal = CRISPY;
                break;
            case "Chewy":
                techniqueCal = CHEWY;
                break;
            case "Homemade":
                techniqueCal = HOMEMADE;
                break;
        }
        return techniqueCal;
    }

    private double getFlourCalories() {
        double flourCalories = 0;

        switch (this.flourType){
            case "White":
                flourCalories = WHITE;
                break;
            case "Wholegrain":
                flourCalories = WHOLEGRAIN;
                break;
        }
        return flourCalories;
    }
}
