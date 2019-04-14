package hardwareComponents;

public class HeavyHardware extends Hardware {
    private static final String TYPE = "Heavy";
    public HeavyHardware(String name, int maxCapacity, int maxMemory) {
        super(name, HeavyHardware.TYPE, maxCapacity, maxMemory);
    }

    @Override
    public void setMaxMemory(int maxMemory) {
        super.setMaxMemory(maxMemory - (maxMemory / 4));
    }

    @Override
    public void setMaxCapacity(int maxCapacity) {
        super.setMaxCapacity(maxCapacity * 2);
    }
}
