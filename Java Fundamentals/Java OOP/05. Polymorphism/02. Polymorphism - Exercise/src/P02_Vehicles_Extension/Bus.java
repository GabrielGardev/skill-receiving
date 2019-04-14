package P02_Vehicles_Extension;

import java.text.DecimalFormat;

public class Bus extends Vehicle {
    public Bus(double fuelQuantity, double consumption, double capacity) {
        super(fuelQuantity, consumption, capacity);
    }

    @Override
    public String drive(double distance) {
        String result = "Bus needs refueling";
        DecimalFormat df = new DecimalFormat("#.##");

        if (distance * this.getConsumption() <= this.getFuelQuantity()) {
            result = String.format("Bus travelled %s km", df.format(distance));
            this.setFuelQuantity(this.getFuelQuantity() - (distance * this.getConsumption()));
        }

        return result;
    }

    public String driveWithPpl(double distance) {
        String result = "Bus needs refueling";
        DecimalFormat df = new DecimalFormat("#.##");

        if (distance * (this.getConsumption() + 1.4) <= this.getFuelQuantity()) {
            result = String.format("Bus travelled %s km", df.format(distance));
            this.setFuelQuantity(this.getFuelQuantity() - (distance * (this.getConsumption() + 1.4)));
        }

        return result;
    }

    @Override
    public String toString() {
        return String.format("Bus: %.2f", this.getFuelQuantity());
    }
}
