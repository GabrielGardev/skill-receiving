package rpg_lab;

import java.util.ArrayList;
import java.util.List;

public class Dummy implements Target{

    private int health;
    private int experience;
    private List<Weapon> possibleWeapon;

    public Dummy(int health, int experience) {
        this.health = health;
        this.experience = experience;
        this.possibleWeapon = new ArrayList<Weapon>();
    }

    public Weapon getPossibleWeapon() {
        return this.possibleWeapon.get(0);
    }

    public int getHealth() {
        return this.health;
    }

    public void takeAttack(int attackPoints) {
        if (this.isDead()) {
            throw new IllegalStateException("Dummy is dead.");
        }

        this.health -= attackPoints;
    }

    public int giveExperience() {
        if (!this.isDead()) {
            throw new IllegalStateException("Target is not dead.");
        }

        return this.experience;
    }

    public boolean isDead() {
        return this.health <= 0;
    }
}
