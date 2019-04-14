package P02_Vehicles_Extension;

import java.text.DecimalFormat;

public class Truck extends Vehicle {
    public Truck(double fuelQuantity, double consumption, double capacity) {
        super(fuelQuantity, consumption, capacity);
    }

    @Override
    public void setConsumption(double consumption) {
        super.setConsumption(consumption + 1.6);
    }


    @Override
    public String drive(double distance) {
        String result = "Truck needs refueling";
        DecimalFormat df = new DecimalFormat("#.##");

        if (distance * this.getConsumption() <= this.getFuelQuantity()){
            result = String.format("Truck travelled %s km", df.format(distance));
            this.setFuelQuantity(this.getFuelQuantity() - (distance * this.getConsumption()));
        }

        return result;
    }

    @Override
    public String refuel(double fuel) {
        fuel = fuel * 0.95;
       return super.refuel(fuel);
    }

    @Override
    public String toString() {
        return String.format("Truck: %.2f", this.getFuelQuantity());
    }
}
