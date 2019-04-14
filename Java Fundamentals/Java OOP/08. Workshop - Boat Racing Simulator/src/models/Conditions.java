package models;

public class Conditions {
    private int windSpeed;
    private int oceanCurrentSpeed;

    public Conditions(int windSpeed, int oceanCurrentSpeed) {
        this.windSpeed = windSpeed;
        this.oceanCurrentSpeed = oceanCurrentSpeed;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public int getOceanCurrentSpeed() {
        return oceanCurrentSpeed;
    }
}
