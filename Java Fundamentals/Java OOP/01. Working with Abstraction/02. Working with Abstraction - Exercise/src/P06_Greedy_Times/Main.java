
package P06_Greedy_Times;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        long capacity = Long.parseLong(reader.readLine());
        String[] input = reader.readLine().split("\\s+");

        Bag bag = new Bag(capacity);

        for (int i = 0; i < input.length; i += 2) {
            String material = input[i];
            long quantity = Long.parseLong(input[i + 1]);



            if (material.length() == 3) {
                bag.addCash(material, quantity);
            } else if (material.toLowerCase().endsWith("gem")) {
                bag.addGems(material, quantity);
            } else if (material.toLowerCase().equals("gold")) {
                bag.addGold(quantity);
            }
        }

        System.out.println(bag.toString());
    }
}