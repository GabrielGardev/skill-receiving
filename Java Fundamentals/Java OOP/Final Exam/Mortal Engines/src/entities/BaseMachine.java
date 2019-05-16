package entities;

import entities.interfaces.Machine;
import entities.interfaces.Pilot;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseMachine implements Machine {
    private String name;
    private Pilot pilot;
    private double attackPoints;
    private double defensePoints;
    private double healthPoints;
    private List<String> targets;

    protected BaseMachine(String name, double attackPoints, double defensePoints, double healthPoints) {
        this.setName(name);
        this.pilot = null;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.setHealthPoints(healthPoints);
        this.targets = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.equals("\\s+")){
            throw new IllegalArgumentException("Machine name cannot be null or empty.");
        }

        this.name = name;
    }

    @Override
    public Pilot getPilot() {
        return this.pilot;
    }

    @Override
    public void setPilot(Pilot pilot) {
        if (pilot == null){
            throw new NullPointerException("Pilot cannot be null.");
        }

        this.pilot = pilot;
    }

    @Override
    public double getHealthPoints() {
        return this.healthPoints;
    }

    @Override
    public void setHealthPoints(double healthPoints) {
        this.healthPoints = healthPoints;
    }

    @Override
    public double getAttackPoints() {
        return this.attackPoints;
    }

    @Override
    public double getDefensePoints() {
        return this.defensePoints;
    }

    @Override
    public List<String> getTargets() {
        return this.targets;
    }

    @Override
    public void attack(String target) {
        if (target == null || target.equals("\\s+")){
            throw new IllegalArgumentException("Attack target cannot be null or empty string.");
        }

        this.targets.add(target);
    }

    @Override
    public String toString() {
        String separator = System.lineSeparator();

        List<String> currentTargets = new ArrayList<>();
        if (this.getTargets().isEmpty()){
            currentTargets.add("None");
        }else {
            currentTargets = this.getTargets();
        }

        StringBuilder sb = new StringBuilder(separator);
        sb.append(" *Health: ").append(String.format("%.2f", this.healthPoints)).append(separator);
        sb.append(" *Attack: ").append(String.format("%.2f", this.attackPoints)).append(separator);
        sb.append(" *Defense: ").append(String.format("%.2f", this.defensePoints)).append(separator);
        sb.append(" *Targets: ").append(String.join(", ", currentTargets)).append(separator);

        return sb.toString();
    }

    public void setAttackPoints(double attackPoints) {
        this.attackPoints = attackPoints;
    }

    public void setDefensePoints(double defensePoints) {
        this.defensePoints = defensePoints;
    }
}
