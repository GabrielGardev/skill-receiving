package models.boats;

import exceptions.ArgumentException;
import models.Conditions;
import models.engines.Engine;

public class PowerBoat extends Boat {
    private Engine firstEngine;
    private Engine secondEngine;
    private boolean hasEngine;

    public PowerBoat(String model, int weight, Engine firstEngine, Engine secondEngine) throws ArgumentException {
        super(model, weight);
        this.firstEngine = firstEngine;
        this.secondEngine = secondEngine;
        this.hasEngine = true;
    }

    @Override
    public boolean HasEngine() {
        return this.hasEngine;
    }

    @Override
    public double getSpeed(Conditions conditions) {
        return (this.firstEngine.getOutput() + this.secondEngine.getOutput())
                - this.getWeight() + (conditions.getOceanCurrentSpeed() / 5.0);
    }
}
