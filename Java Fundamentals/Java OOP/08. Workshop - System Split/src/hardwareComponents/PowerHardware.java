package hardwareComponents;

public class PowerHardware extends Hardware {
    private static final String TYPE = "Power";

    public PowerHardware(String name, int maxCapacity, int maxMemory) {
        super(name, PowerHardware.TYPE, maxCapacity, maxMemory);
    }

    @Override
    public void setMaxCapacity(int maxCapacity) {
        super.setMaxCapacity(maxCapacity - ((maxCapacity * 3) / 4));
    }

    @Override
    public void setMaxMemory(int maxMemory) {
        super.setMaxMemory(maxMemory + ((maxMemory * 3) / 4));
    }
}
