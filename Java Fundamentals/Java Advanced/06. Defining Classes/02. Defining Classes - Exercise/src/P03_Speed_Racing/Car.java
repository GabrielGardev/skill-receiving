package P03_Speed_Racing;

public class Car {
    private String model;
    private Double fuelAmount;
    private Double fuelCostForOneKm;
    private Double distanceTraveled;

    public Car(String model, Double fuelAmount, Double fuelCostForOneKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostForOneKm = fuelCostForOneKm;
        this.distanceTraveled = 0.0;
    }

    public boolean drive(Double amountOfKm){
        double fuelForRide = amountOfKm * this.fuelCostForOneKm;

        if (fuelAmount >= fuelForRide){
            this.fuelAmount -= fuelForRide;
            this.distanceTraveled += amountOfKm;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %.0f", this.model, this.fuelAmount, this.distanceTraveled);
    }
}

