package fakes;

import rpg_lab.Axe;
import rpg_lab.Target;
import rpg_lab.Weapon;

public class FakeAxe implements Weapon {
    public void attack(Target target) {

    }

    public int getAttackPoints() {
        return 10;
    }

    public int getDurabilityPoints() {
        return 10;
    }
}
