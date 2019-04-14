package resources;

import observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Dragon implements Target {

    private String id;
    private int hp;
    private int reward;
    private List<Observer> observers;

    public Dragon(String id, int hp,  int reward) {
        this.id = id;
        this.hp = hp;
        this.reward = reward;
        this.observers = new ArrayList<>();
    }

    @Override
    public int getHp() {
        return this.hp;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public int getReward() {
        return this.reward;
    }

    @Override
    public void setHp(int newHP) {
        this.hp = newHP;
    }

    @Override
    public void register(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : this.observers) {
            observer.update(this.reward);
        }
    }
}
