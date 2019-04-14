package resources;

public abstract class Hero implements Attacker {
    private String id;
    private int dmg;
    private Target target;
    private int XP;

    @Override
    public void update(int reward) {
        this.setXP(reward);
    }

    public Hero(String id, int dmg) {
        this.id = id;
        this.dmg = dmg;
        this.XP = 0;
    }

    @Override
    public void setXP(int reward) {
        this.XP += reward;
    }

    @Override
    public int getXP() {
        return XP;
    }

    @Override
    public void setTarget(Target target) {
        this.target = target;
    }

    @Override
    public Target getTarget() {
        return this.target;
    }


    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public int getDmg() {
        return this.dmg;
    }
}
