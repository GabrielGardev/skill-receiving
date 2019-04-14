package resources;

import observer.Subject;

public interface Target extends Subject {
    int getHp();
    String getId();
    int getReward();

    void setHp(int newHP);
}
