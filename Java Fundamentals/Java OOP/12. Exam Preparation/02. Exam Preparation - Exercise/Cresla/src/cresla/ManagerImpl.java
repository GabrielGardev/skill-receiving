package cresla;

import cresla.entities.modules.CooldownSystem;
import cresla.entities.modules.CryogenRod;
import cresla.entities.modules.HeatProcessor;
import cresla.entities.reactors.CryoReactor;
import cresla.entities.reactors.HeatReactor;
import cresla.interfaces.*;
import cresla.interfaces.Module;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ManagerImpl implements Manager {
    private int id;
    private Map<Integer, Reactor> reactors;
    private Map<Integer, Module> modules;

    public ManagerImpl() {
        this.id = 0;
        this.reactors = new HashMap<>();
        this.modules = new HashMap<>();
    }

    @Override
    public String reactorCommand(List<String> arguments) {
        this.id++;
        String reactorType = arguments.get(0);
        int additionalParameter = Integer.parseInt(arguments.get(1));
        int moduleCapacity = Integer.parseInt(arguments.get(2));

        Reactor reactor = null;

        switch (reactorType){
            case "Cryo":
                reactor = new CryoReactor(this.id, additionalParameter, moduleCapacity);
                break;
            case "Heat":
                reactor = new HeatReactor(this.id, additionalParameter, moduleCapacity);
                break;
        }

        this.reactors.put(this.id, reactor);

        return String.format("Created %s Reactor - %d", reactorType, this.id);
    }

    @Override
    public String moduleCommand(List<String> arguments) {
        this.id++;
        int reactorId = Integer.parseInt(arguments.get(0));
        String type = arguments.get(1);
        int additionalParam = Integer.parseInt(arguments.get(2));

        Module module;

        if (type.equals("CryogenRod")){
            module = new CryogenRod(this.id, additionalParam);
            this.reactors.get(reactorId).addEnergyModule((EnergyModule) module);
        }else {
            if (type.equals("HeatProcessor")){
                module = new HeatProcessor(this.id, additionalParam);
            }else {
                module = new CooldownSystem(this.id, additionalParam);
            }
            this.reactors.get(reactorId).addAbsorbingModule((AbsorbingModule) module);
        }

        this.modules.put(this.id, module);

        return String.format("Added %s - %d to Reactor - %d", type, this.id, reactorId);
    }

    @Override
    public String reportCommand(List<String> arguments) {
        int id = Integer.parseInt(arguments.get(0));

        return this.modules.containsKey(id) ? this.modules.get(id).toString() : this.reactors.get(id).toString();
    }

    @Override
    public String exitCommand(List<String> arguments) {
        long cryoReactorsCount = this.reactors.values().stream().filter(x -> x instanceof CryoReactor).count();
        long heatReactorsCount = this.reactors.values().stream().filter(x -> x instanceof HeatReactor).count();

        long energyModules = this.modules.values().stream().filter(x -> x instanceof EnergyModule).count();
        long absorbingModules = this.modules.values().stream().filter(x -> x instanceof AbsorbingModule).count();

        long totalEnergy = this.reactors.values().stream().mapToLong(Reactor::getTotalEnergyOutput).sum();
        long totalHeatAbsorbing = this.reactors.values().stream().mapToLong(Reactor::getTotalHeatAbsorbing).sum();

        return String.format("Cryo Reactors: %d\r\n" +
                        "Heat Reactors: %d\r\n" +
                        "Energy Modules: %d\r\n" +
                        "Absorbing Modules: %d\r\n" +
                        "Total Energy Output: %d\r\n" +
                        "Total Heat Absorbing: %d",
                cryoReactorsCount,
                heatReactorsCount,
                energyModules,
                absorbingModules,
                totalEnergy,
                totalHeatAbsorbing);
    }
}
