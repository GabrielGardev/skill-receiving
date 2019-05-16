package entities;

import entities.interfaces.Tank;

public class TankImpl extends BaseMachine implements Tank {
    private static final double HEALTH_POINTS = 100.0;
    private static final double ATTACK_POINTS = 40.0;
    private static final double DEFENSE_POINTS = 30.0;

    private boolean defenseMode;
    private static final double attackPointsModifier = ATTACK_POINTS;
    private static final double defensePointsModifier = DEFENSE_POINTS;


    public TankImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints - attackPointsModifier, defensePoints + defensePointsModifier, HEALTH_POINTS);
        this.defenseMode = true;
    }

    @Override
    public boolean getDefenseMode() {
        return this.defenseMode;
    }

    @Override
    public void toggleDefenseMode() {
        if (this.defenseMode == true) {
            this.defenseMode = false;
            this.setAttackPoints(this.getAttackPoints() + attackPointsModifier);
            this.setDefensePoints(this.getDefensePoints() - defensePointsModifier);
        } else {
            this.defenseMode = true;
            this.setAttackPoints(this.getAttackPoints() - attackPointsModifier);
            this.setDefensePoints(this.getDefensePoints() + defensePointsModifier);
        }
    }

    @Override
    public String toString() {
        return "- " + super.getName()
                + System.lineSeparator()
                + " *Type: Tank"
                + super.toString()
                + (this.getDefenseMode() ? " *Defense Mode(ON)" : " *Defense Mode(OFF)");
    }
}
