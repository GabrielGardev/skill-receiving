package P02_Vehicles_Extension;

public abstract class Vehicle implements VehicleOptions {
    private double fuelQuantity;
    private double consumption;
    private double capacity;

    public Vehicle(double fuelQuantity, double consumption, double capacity) {
        this.fuelQuantity = fuelQuantity;
        this.capacity = capacity;
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

    public double getCapacity() {
        return capacity;
    }

    @Override
    public String refuel(double fuel) {
        String result = null;
        if (fuel <= 0 || this.getFuelQuantity() + fuel < 0) {
            result = "Fuel must be a positive number";
        } else if (this.getFuelQuantity() + fuel > this.getCapacity()) {
            result = "Cannot fit fuel in tank";
        } else {
            this.setFuelQuantity(this.getFuelQuantity() + fuel);
        }
        return result;
    }
}
