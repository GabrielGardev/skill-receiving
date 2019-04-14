package commands;

import resources.Attacker;
import resources.Target;

public class AttackCommand implements Command {
    private Attacker attacker;

    public AttackCommand(Attacker attacker) {
        this.attacker = attacker;
    }

    @Override
    public void execute() {
        Target target = this.attacker.getTarget();

        int newHP = target.getHp() - this.attacker.getDmg();
        target.setHp(newHP);

        if (newHP <= 0){
            this.attacker.setXP(target.getReward());
        }
    }
}
