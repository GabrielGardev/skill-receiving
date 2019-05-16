package entities;

import entities.interfaces.Fighter;

public class FighterImpl extends BaseMachine implements Fighter {
    private static final double HEALTH_POINTS = 200.0;
    private static final double ATTACK_POINTS = 50.0;
    private static final double DEFENSE_POINTS = 25.0;

    private boolean aggressiveMode;
    private static final double attackPointsModifier = ATTACK_POINTS;
    private static final double defensePointsModifier = DEFENSE_POINTS;

    public FighterImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints + attackPointsModifier, defensePoints - defensePointsModifier, HEALTH_POINTS);
        this.aggressiveMode = true;
    }

    @Override
    public boolean getAggressiveMode() {
        return this.aggressiveMode;
    }

    @Override
    public void toggleAggressiveMode() {
        if (this.aggressiveMode == true){
            this.aggressiveMode = false;
            this.setAttackPoints(this.getAttackPoints() - attackPointsModifier);
            this.setDefensePoints(this.getDefensePoints() + DEFENSE_POINTS);
        }else {
            this.aggressiveMode = true;
            this.setAttackPoints(this.getAttackPoints() + attackPointsModifier);
            this.setDefensePoints(this.getDefensePoints() - defensePointsModifier);
        }
    }

    @Override
    public String toString() {
        return  "- " + super.getName()
                + System.lineSeparator()
                + " *Type: Fighter"
                + super.toString()
                + (this.getAggressiveMode() ? " *Aggressive Mode(ON)" : " *Aggressive Mode(OFF)");
    }

}
