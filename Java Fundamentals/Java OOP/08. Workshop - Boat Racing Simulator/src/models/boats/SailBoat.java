package models.boats;

import exceptions.ArgumentException;
import models.Conditions;

public class SailBoat extends Boat {
    private int sailEfficiency;


    public SailBoat(String model, int weight, int sailEfficiency) throws ArgumentException {
        super(model, weight);
        this.setSailEfficiency(sailEfficiency);
    }

    private void setSailEfficiency(int sailEfficiency) throws ArgumentException {
        if (sailEfficiency < 1 || sailEfficiency > 100){
            throw new ArgumentException("Sail Effectiveness must be between [1...100].");
        }
        this.sailEfficiency = sailEfficiency;
    }

    @Override
    public double getSpeed(Conditions conditions) {
        return (conditions.getWindSpeed() * (this.sailEfficiency / 100.0))
                - this.getWeight() + (conditions.getOceanCurrentSpeed() / 2.0) ;
    }
}
