import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class P02_Knapsack_Iterative {
    static class Item implements Comparable<Item> {

        public String name;
        public int weight;
        public int price;

        public Item(String name, int weight, int price) {
            this.name = name;
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Item o) {
            return name.compareTo(o.name);
        }
    }

    static class Knapsack {

        public int totalWeight;
        public int totalValue;
        public TreeSet<Item> items;

        public Knapsack(TreeSet<Item> items) {
            this.totalWeight = items.stream().mapToInt(i -> i.weight).sum();
            this.totalValue = items.stream().mapToInt(i -> i.price).sum();
            this.items = new TreeSet<>(items);
        }

        @Override
        public String toString() {

            StringBuilder knapsackAsStringBuilder = new StringBuilder();

            knapsackAsStringBuilder.append("Total Weight: ").append(totalWeight)
                    .append(System.lineSeparator())
                    .append("Total Value: ").append(totalValue)
                    .append(System.lineSeparator());

            items.forEach(i -> knapsackAsStringBuilder.append(i.name).append(System.lineSeparator()));

            return knapsackAsStringBuilder.toString().trim();
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int capacity = Integer.parseInt(reader.readLine());

        List<Item> items = new ArrayList<>();

        String line;

        while (!(line = reader.readLine()).equals("end")) {
            String[] itemInfo = line.split("\\s+");
            String name = itemInfo[0];
            int weight = Integer.parseInt(itemInfo[1]);
            int price = Integer.parseInt(itemInfo[2]);
            Item item = new Item(name, weight, price);
            items.add(item);
        }

        int[][] maxValues = new int[items.size() + 1][capacity + 1];
        boolean[][] itemsIncluded = new boolean[items.size() + 1][capacity + 1];

        for (int i = 0; i < items.size(); i++) {
            for (int currCapacity = 1; currCapacity <= capacity; currCapacity++) {
                Item currentItem = items.get(i);
                if (currentItem.weight > currCapacity) {
                    continue;
                }
                int valueIncluded = currentItem.price + maxValues[i][currCapacity - currentItem.weight];
                if (valueIncluded > maxValues[i][currCapacity]) {
                    maxValues[i + 1][currCapacity] = valueIncluded;
                    itemsIncluded[i + 1][currCapacity] = true;
                } else {
                    maxValues[i + 1][currCapacity] = maxValues[i][currCapacity];
                }
            }
        }

        TreeSet<Item> takenItems = new TreeSet<>();

        for (int i = items.size(); i > 0; i--) {

            if (!itemsIncluded[i][capacity]) {
                continue;
            }

            Item item = items.get(i - 1);
            takenItems.add(item);
            capacity -= item.weight;
        }

        Knapsack knapsack = new Knapsack(takenItems);

        System.out.println(knapsack);
    }
}
