package hardwareComponents;

import softwareComponents.Software;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Hardware {
    private String name;
    private String type;
    private int maxCapacity;
    private int maxMemory;
    private Map<String, Software> softwareComponents;
    private int usedCapacity;
    private int usedMemory;

    public Hardware(String name, String type, int maxCapacity, int maxMemory) {
        this.name = name;
        this.type = type;
        this.setMaxCapacity(maxCapacity);
        this.setMaxMemory(maxMemory);
        this.softwareComponents = new LinkedHashMap<>();
        this.usedCapacity = 0;
        this.usedMemory = 0;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public void setMaxMemory(int maxMemory) {
        this.maxMemory = maxMemory;
    }

    private boolean hasFreeCapacity(int capacity){
        return (this.maxCapacity - (this.usedCapacity + capacity)) >= 0;
    }

    private boolean hasFreeMemory(int memory){
        return (this.maxMemory - (this.usedMemory + memory)) >= 0;
    }

    public void addSoftware(Software software){
        if (this.hasFreeCapacity(software.getCapacityConsumption())
            && this.hasFreeMemory(software.getMemoryConsumption())){
            this.softwareComponents.putIfAbsent(software.getName(), software);
            this.usedMemory += software.getMemoryConsumption();
            this.usedCapacity += software.getCapacityConsumption();
        }
    }

    public String getName() {
        return name;
    }

    public void removeSoftware(String name){
        if (this.softwareComponents.containsKey(name)){
            Software software = this.softwareComponents.remove(name);
            this.usedCapacity -= software.getCapacityConsumption();
            this.usedMemory -= software.getMemoryConsumption();
        }
    }
    public int softwareComponentsCount(){
        return this.softwareComponents.size();
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getMaxMemory() {
        return maxMemory;
    }

    public int getUsedCapacity() {
        return usedCapacity;
    }

    public int getUsedMemory() {
        return usedMemory;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        String separator = java.lang.System.lineSeparator();

        StringBuilder sb = new StringBuilder("Hardware Component - ");
        sb.append(this.getName())
                .append(separator);

        int countOfExpressSoftwareComponents = (int) this.softwareComponents.keySet()
                .stream()
                .filter(e -> this.softwareComponents.get(e).getType().equals("Express"))
                .count();

        int countOfLightSoftwareComponents = this.softwareComponents.size() - countOfExpressSoftwareComponents;

            sb.append("Express Software Components - ")
                    .append(countOfExpressSoftwareComponents)
                    .append(separator)
                    .append("Light Software Components - ")
                    .append(countOfLightSoftwareComponents)
                    .append(separator)
                    .append("Memory Usage: ")
                    .append(this.getUsedMemory())
                    .append(" / ")
                    .append(this.getMaxMemory())
                    .append(separator)
                    .append("Capacity Usage: ")
                    .append(this.getUsedCapacity())
                    .append(" / ")
                    .append(this.getMaxCapacity())
                    .append(separator)
                    .append("Type: ")
                    .append(this.getType())
                    .append(separator)
                    .append("Software Components: ");

        List<String> names = this.softwareComponents.values()
                .stream()
                .map(Software::getName)
                .collect(Collectors.toList());

        if (names.isEmpty()){
            sb.append("None");
        }else {
            sb.append(String.join(", ", names));
        }

        return sb.toString();
    }
}
