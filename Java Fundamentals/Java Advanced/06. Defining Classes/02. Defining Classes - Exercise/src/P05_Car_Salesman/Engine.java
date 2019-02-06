package P05_Car_Salesman;

public class Engine {
    private String engineModel;
    private int enginePower;
    private String  displacement;
    private String efficiency;

    public Engine(String engineModel, int enginePower) {
        this.engineModel = engineModel;
        this.enginePower = enginePower;
    }

    public void setDisplacement(String  displacement) {
        this.displacement = displacement;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    public String getEngineModel() {
        return engineModel;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public String getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }
}
