package entities;

import entities.interfaces.Machine;
import entities.interfaces.Pilot;

import java.util.ArrayList;
import java.util.List;

public class PilotImpl implements Pilot {

    private String name;
    private List<Machine> machines;

    public PilotImpl(String name) {
        this.setName(name);
        this.machines = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addMachine(Machine machine) {
        if (machine == null){
            throw new NullPointerException("Null machine cannot be added to the pilot.");
        }

        this.machines.add(machine);
    }

    @Override
    public List<Machine> getMachines() {
        return this.machines;
    }

    @Override
    public String report() {
        return this.toString();
    }

    private void setName(String name) {
        if (name == null || name.equals("\\s+")){
            throw new IllegalArgumentException("Pilot name cannot be null or empty string.");
        }

        this.name = name;
    }

    @Override
    public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.getName()).append(" - ").append(this.getMachines().size()).append(" machines");

            if (this.getMachines().isEmpty()){
                return sb.toString();
            }

        for (Machine machine : this.getMachines()) {
            sb.append(System.lineSeparator());
            sb.append(machine.toString());
        }

        return sb.toString();
    }
}
