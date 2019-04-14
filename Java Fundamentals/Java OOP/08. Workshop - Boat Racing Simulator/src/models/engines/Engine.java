package models.engines;

import exceptions.ArgumentException;

public abstract class Engine {
    private String model;
    private int horsepower;
    private int displacement;

    public Engine(String model, int horsepower, int displacement) throws ArgumentException {
        this.setModel(model);
        this.setHorsepower(horsepower);
        this.setDisplacement(displacement);
    }

    private void setHorsepower(int horsepower) throws ArgumentException {
        if (horsepower <= 0){
            throw new ArgumentException("Horsepower must be a positive integer.");
        }
        this.horsepower = horsepower;
    }

    private void setDisplacement(int displacement) throws ArgumentException {
        if (displacement <= 0){
            throw new ArgumentException("Displacement must be a positive integer.");
        }
        this.displacement = displacement;
    }

    private void setModel(String model) throws ArgumentException {
        if (model.length() < 3){
            throw new ArgumentException("Model's name must be at least 3 symbols long.");
        }
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public int getDisplacement() {
        return displacement;
    }

    public abstract int getOutput();

    @Override
    public String toString() {
        return String.format("Engine model %s with %d HP and displacement %d cm3 created successfully.",
                this.getModel(), this.getHorsepower(), this.getDisplacement());
    }


}
