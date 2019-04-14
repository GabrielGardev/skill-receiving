package models.boats;

import exceptions.ArgumentException;
import models.Conditions;
import models.engines.Engine;

public class Yacht extends Boat {
    private Engine engine;
    private int cargoWeight;
    private boolean hasEngine;

    public Yacht(String model, int weight, Engine engine, int cargoWeight) throws ArgumentException {
        super(model, weight);
        this.engine = engine;
        this.setCargoWeight(cargoWeight);
        this.hasEngine = true;
    }

    private void setCargoWeight(int cargoWeight) {
        if (cargoWeight <= 0){
            throw new IllegalArgumentException("Cargo Weight must be a positive integer.");
        }
        this.cargoWeight = cargoWeight;
    }

    @Override
    public boolean HasEngine() {
        return this.hasEngine;
    }

    @Override
    public double getSpeed(Conditions conditions) {
        return this.engine.getOutput() - (this.getWeight() + this.cargoWeight)
                + (conditions.getOceanCurrentSpeed() / 2.0);
    }
}
