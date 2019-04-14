package fakes;

import rpg_lab.Target;
import rpg_lab.Weapon;

public class FakeTarget implements Target {
    public void takeAttack(int attackPoints) {

    }

    public int getHealth() {
        return 0;
    }

    public int giveExperience() {
        return 10;
    }

    public boolean isDead() {
        return true;
    }

    public Weapon getPossibleWeapon() {
        return null;
    }
}
