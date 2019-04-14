package cresla.entities.reactors;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.*;

public abstract class ReactorImpl implements Reactor {
    private int id;
    private Container container;

    ReactorImpl(int id, int capacity) {
        this.id = id;
        this.container = new ModuleContainer(capacity);
    }

    @Override
    public long getTotalEnergyOutput() {
        return this.container.getTotalEnergyOutput();
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return this.container.getTotalHeatAbsorbing();
    }

    @Override
    public int getModuleCount() {
        return this.container.getModuleByInputCount();
    }

    @Override
    public void addEnergyModule(EnergyModule energyModule) {
        this.container.addEnergyModule(energyModule);
    }

    @Override
    public void addAbsorbingModule(AbsorbingModule absorbingModule) {
        this.container.addAbsorbingModule(absorbingModule);
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return String.format("%s - %d%n" +
                        "Energy Output: %d%n" +
                        "Heat Absorbing: %d%n" +
                        "Modules: %d",this.getClass().getSimpleName(),
                this.getId(),
                this.getTotalEnergyOutput() > this.getTotalHeatAbsorbing() ? 0 : this.getTotalEnergyOutput(),
                this.getTotalHeatAbsorbing(),
                this.getModuleCount());
    }
}
