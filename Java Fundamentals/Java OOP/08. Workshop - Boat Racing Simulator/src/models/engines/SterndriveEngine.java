package models.engines;

import exceptions.ArgumentException;

public class SterndriveEngine extends Engine{

    public SterndriveEngine(String model, int horsepower, int displacement) throws ArgumentException {
        super(model, horsepower, displacement);
    }

    @Override
    public int getOutput() {
        return (this.getHorsepower() * 7) + this.getDisplacement();
    }
}
