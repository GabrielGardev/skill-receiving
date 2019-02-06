package P04_Raw_Data;

public class Tire {
    private double tirePressure;
    private int tireAge;

    public Tire(double tirePressure, int tireAge) {
        this.tirePressure = tirePressure;
        this.tireAge = tireAge;
    }

    public double getTirePressure() {
        return tirePressure;
    }

    public int getTireAge() {
        return tireAge;
    }
}
