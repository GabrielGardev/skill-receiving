package models.boats;

import exceptions.ArgumentException;
import models.Conditions;

public abstract class Boat {
    private String model;
    private int weight;
    private boolean hasEngine;

    public Boat(String model, int weight) throws ArgumentException {
        this.setModel(model);
        this.setWeight(weight);
        this.hasEngine = false;
    }

    private void setModel(String model) throws ArgumentException {
        if (model.length() < 5){
            throw new ArgumentException("Model's name must be at least 5 symbols long.");
        }
        this.model = model;
    }

    private void setWeight(int weight) throws ArgumentException {
        if (weight <= 0){
            throw new ArgumentException("Weight must be a positive integer.");
        }
        this.weight = weight;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return String.format("with model %s registered successfully.", this.model);
    }

    public boolean HasEngine() {
        return hasEngine;
    }

    public abstract double getSpeed(Conditions conditions);

    public int getWeight() {
        return weight;
    }
}
