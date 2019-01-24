package P3_Car_Salesman;

public class Car {
    private String model;
    private Engine engine;
    private String  weight;
    private String color;

    public Car(String model) {
        this.model = model;
    }

    public void setWeight(String  weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public String getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return String.format("%s:%n" +
                "%s:%n" +
                "Power: %d%n" +
                "Displacement: %s%n" +
                "Efficiency: %s%n" +
                "Weight: %s%n" +
                "Color: %s", getModel(), getEngine().getEngineModel(),
                getEngine().getEnginePower(),getEngine().getDisplacement(),
                getEngine().getEfficiency(),getWeight(),getColor());
    }
}
