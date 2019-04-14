package resources;

import observer.Observer;

public interface Attacker extends Observer {
    String getId();
    int getDmg();
    void setTarget(Target target);
    Target getTarget();
    int getXP();
    void setXP(int reward);
}
