package P01_Vehicles;

public abstract class Vehicle implements VehicleOptions{
    private double fuelQuantity;
    private double consumption;

    public Vehicle(double fuelQuantity, double consumption) {
        this.fuelQuantity = fuelQuantity;
        this.setConsumption(consumption);
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }
}
