package core;

import common.OutputMessages;
import core.interfaces.MachineFactory;
import core.interfaces.PilotFactory;
import core.interfaces.MachinesManager;

import entities.PilotImpl;
import entities.TankImpl;
import entities.interfaces.Fighter;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;
import entities.interfaces.Tank;

import java.util.Map;

public class MachinesManagerImpl implements MachinesManager {

    private PilotFactory pilotFactory;
    private MachineFactory machineFactory;
    private Map<String, Pilot> pilots;
    private Map<String, Machine> machines;

    public MachinesManagerImpl(PilotFactory pilotFactory,
                               MachineFactory machineFactory,
                               Map<String, Pilot> pilots,
                               Map<String, Machine> machines) {
        this.pilotFactory = pilotFactory;
        this.machineFactory = machineFactory;
        this.pilots = pilots;
        this.machines = machines;
    }


    @Override
    public String hirePilot(String name) {
        Pilot pilot = this.pilotFactory.createPilot(name);

        if (this.pilots.containsKey(name)) {
            return String.format(OutputMessages.pilotExists, name);
        }

        this.pilots.put(name, pilot);

        return String.format(OutputMessages.pilotHired, name);
    }

    @Override
    public String manufactureTank(String name, double attackPoints, double defensePoints) {
        Tank tank = this.machineFactory.createTank(name, attackPoints, defensePoints);

        if (this.machines.containsKey(name)) {
            return String.format(OutputMessages.machineExists, name);
        }

        this.machines.put(name, tank);

        return String.format(OutputMessages.tankManufactured, name, attackPoints, defensePoints);
    }

    @Override
    public String manufactureFighter(String name, double attackPoints, double defensePoints) {
        Fighter fighter = this.machineFactory.createFighter(name, attackPoints, defensePoints);

        if (this.machines.containsKey(name)) {
            return String.format(OutputMessages.machineExists, name);
        }

        this.machines.put(name, fighter);

        return String.format(OutputMessages.fighterManufactured, name, attackPoints, defensePoints);
    }

    @Override
    public String engageMachine(String selectedPilotName, String selectedMachineName) {
        if (!this.pilots.containsKey(selectedPilotName)) {
            return String.format(OutputMessages.pilotNotFound, selectedPilotName);
        }

        if (!this.machines.containsKey(selectedMachineName)) {
            return String.format(OutputMessages.machineNotFound, selectedMachineName);
        }
        Pilot currentPilot = this.pilots.get(selectedPilotName);
        Machine currentMachine = this.machines.get(selectedMachineName);

        if (currentMachine.getPilot() != null) {
            return String.format(OutputMessages.machineHasPilotAlready, selectedMachineName);
        }

        currentPilot.addMachine(currentMachine);
        currentMachine.setPilot(currentPilot);

        return String.format(OutputMessages.machineEngaged, selectedPilotName, selectedMachineName);
    }

    @Override
    public String attackMachines(String attackingMachineName, String defendingMachineName) {
        if (!this.machines.containsKey(attackingMachineName)){
            return String.format(OutputMessages.machineNotFound, attackingMachineName);
        }

        if (!this.machines.containsKey(defendingMachineName)){
            return String.format(OutputMessages.machineNotFound, defendingMachineName);
        }

        Machine attacker = this.machines.get(attackingMachineName);
        Machine defender = this.machines.get(defendingMachineName);

        if (attacker.getAttackPoints() > defender.getDefensePoints()){
            double newHP = defender.getHealthPoints() - attacker.getAttackPoints();
            if (newHP < 0){
                newHP = 0;
            }
            defender.setHealthPoints(newHP);
        }
        attacker.attack(defender.getName());

        return String.format(OutputMessages.attackSuccessful,
                defendingMachineName,
                attackingMachineName,
                defender.getHealthPoints());
    }

    @Override
    public String pilotReport(String pilotName) {
        if (!this.pilots.containsKey(pilotName)){
            return String.format(OutputMessages.pilotNotFound, pilotName);
        }

        return this.pilots.get(pilotName).report();
    }

    @Override
    public String toggleFighterAggressiveMode(String fighterName) {
        if (!this.machines.containsKey(fighterName)){
            return String.format(OutputMessages.machineNotFound, fighterName);
        }

        if (this.machines.get(fighterName) instanceof Fighter){
            ((Fighter) this.machines.get(fighterName)).toggleAggressiveMode();
            return String.format(OutputMessages.fighterOperationSuccessful, fighterName);
        }

        return String.format(OutputMessages.notSupportedOperation, fighterName);
    }

    @Override
    public String toggleTankDefenseMode(String tankName) {
        if (!this.machines.containsKey(tankName)){
            return String.format(OutputMessages.machineNotFound, tankName);
        }

        if (this.machines.get(tankName) instanceof Tank){
            ((Tank) this.machines.get(tankName)).toggleDefenseMode();
            return String.format(OutputMessages.tankOperationSuccessful, tankName);
        }

        return String.format(OutputMessages.notSupportedOperation, tankName);
    }
}
