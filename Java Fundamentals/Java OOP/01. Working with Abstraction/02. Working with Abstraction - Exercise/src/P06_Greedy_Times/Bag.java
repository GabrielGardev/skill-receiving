package P06_Greedy_Times;

import java.util.HashMap;
import java.util.Map;

public class Bag {
    private long capacity;
    private long gold;
    private long currentCapacity;
    private Map<String, Long> gems;
    private long totalGems;
    private Map<String, Long> cash;
    private long totalCash;
    private boolean goldIsAdded;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.gold = 0;
        this.currentCapacity = 0;
        this.gems = new HashMap<>();
        this.totalGems = 0;
        this.cash = new HashMap<>();
        this.totalCash = 0;
        this.goldIsAdded = false;
    }

    private static int compare(Map.Entry<String, Long> a, Map.Entry<String, Long> b) {
        int result = 0;
        result = b.getKey().compareTo(a.getKey());
        if (result == 0) {
            result = a.getValue().compareTo(b.getValue());
        }
        return result;
    }

    public void addCash(String material, long quantity) {
        if(hasFreeCapacity(quantity) && this.totalGems >= this.totalCash + quantity){
            this.cash.putIfAbsent(material, 0L);
            this.cash.put(material, this.cash.get(material) + quantity);
            this.totalCash += quantity;
            this.currentCapacity += quantity;
        }
    }

    private boolean hasFreeCapacity(long quantity) {
        return this.currentCapacity + quantity <= this.capacity;
    }

    public void addGold(long quantity) {
        if (hasFreeCapacity(quantity)) {
            this.gold += quantity;
            this.currentCapacity += quantity;
            this.goldIsAdded = true;
        }
    }

    public void addGems(String material, long quantity) {
        if (hasFreeCapacity(quantity) && this.totalGems + quantity <= this.gold){
            this.gems.putIfAbsent(material, 0L);
            this.gems.put(material, this.gems.get(material) + quantity);
            this.totalGems += quantity;
            this.currentCapacity += quantity;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (this.goldIsAdded){
            sb.append("<Gold> $").append(this.gold).append(System.lineSeparator());
            sb.append("##Gold - ").append(this.gold).append(System.lineSeparator());
        }
        if (this.gems.size() > 0){
            sb.append("<Gem> $").append(this.totalGems).append(System.lineSeparator());

            this.gems.entrySet().stream()
                    .sorted(Bag::compare).forEach(x -> {
                sb.append(String.format("##%s - %d", x.getKey(), x.getValue())).append(System.lineSeparator());
            });
        }

        if (this.cash.size() > 0){
            sb.append("<Cash> $").append(this.totalCash).append(System.lineSeparator());

            this.cash.entrySet().stream()
                    .sorted(Bag::compare).forEach(x -> {
                sb.append(String.format("##%s - %d", x.getKey(), x.getValue())).append(System.lineSeparator());
            });
        }
        return sb.toString();
    }
}
