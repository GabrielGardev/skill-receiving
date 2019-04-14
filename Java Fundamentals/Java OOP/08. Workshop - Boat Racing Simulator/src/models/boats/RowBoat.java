package models.boats;

import exceptions.ArgumentException;
import models.Conditions;

public class RowBoat extends Boat {
    private int oars;

    public RowBoat(String model, int weight, int oars) throws ArgumentException {
        super(model, weight);
        this.setOars(oars);
    }

    private void setOars(int oars) {
        if (oars <= 0){
            throw new IllegalArgumentException("Oars must be a positive integer.");
        }
        this.oars = oars;
    }

    @Override
    public double getSpeed(Conditions conditions) {
        return (this.oars * 100) - this.getWeight() + conditions.getOceanCurrentSpeed();
    }
}
