package core;

import hardwareComponents.Hardware;
import softwareComponents.Software;

import java.util.LinkedHashMap;
import java.util.Map;

public class System {
    private Map<String, Hardware> hardwareComponents;

    public System() {
        this.hardwareComponents = new LinkedHashMap<>();
    }

    public void addHardware(Hardware hardware) {
        this.hardwareComponents.putIfAbsent(hardware.getName(), hardware);
    }

    public void addSoftware(String hardwareName, Software software) {
        if (this.containsHardware(hardwareName)) {
            this.hardwareComponents.get(hardwareName).addSoftware(software);
        }
    }

    public void releaseSoftwareComponent(String hardwareName, String softwareName) {
        if (this.containsHardware(hardwareName)) {
            this.hardwareComponents.get(hardwareName).removeSoftware(softwareName);
        }
    }

    public boolean containsHardware(String hardwareName) {
        return this.hardwareComponents.containsKey(hardwareName);
    }

    public String analyze() {
        String separator = java.lang.System.lineSeparator();
        StringBuilder sb = new StringBuilder("System Analysis");
        sb.append(separator);

        int countOfHardwareComponents = this.hardwareComponents.size();
        int countOfSoftwareComponents = 0;

        int totalOperationalMemoryInUse = 0;
        int maximumMemory = 0;
        int totalCapacityTaken = 0;
        int maximumCapacity = 0;

        for (Hardware value : hardwareComponents.values()) {
            countOfSoftwareComponents += value.softwareComponentsCount();
            totalOperationalMemoryInUse += value.getUsedMemory();
            maximumMemory += value.getMaxMemory();
            totalCapacityTaken += value.getUsedCapacity();
            maximumCapacity += value.getMaxCapacity();
        }

        sb.append("Hardware Components: ")
                .append(countOfHardwareComponents)
                .append(separator)
                .append("Software Components: ")
                .append(countOfSoftwareComponents)
                .append(separator)
                .append("Total Operational Memory: ")
                .append(totalOperationalMemoryInUse)
                .append(" / ")
                .append(maximumMemory)
                .append(separator)
                .append("Total Capacity Taken: ")
                .append(totalCapacityTaken)
                .append(" / ")
                .append(maximumCapacity);

        return sb.toString();
    }

    @Override
    public String toString() {
        String separator = java.lang.System.lineSeparator();

        StringBuilder sb = new StringBuilder();

        this.hardwareComponents.entrySet()
                .stream()
                .filter(e -> e.getValue().getType().equals("Power"))
                .forEach(e ->
                        sb.append(e.getValue().toString())
                                .append(separator));

        this.hardwareComponents.entrySet()
                .stream()
                .filter(e -> e.getValue().getType().equals("Heavy"))
                .forEach(e ->
                        sb.append(e.getValue().toString())
                                .append(separator));

        return sb.toString();
    }
}
