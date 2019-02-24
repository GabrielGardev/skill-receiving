import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class P03_Sum_of_Coins {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<Integer, Integer> coins = new LinkedHashMap<>();

        String line = reader.readLine().replace("Coins: ", "");

        ArrayList<Integer> list = Arrays.stream(line.split(", "))
                .map(Integer::parseInt)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toCollection(ArrayList::new));
        for (Integer integer : list) {
            coins.putIfAbsent(integer, 0);
        }

        int sum = Integer.parseInt(reader.readLine().split(" ")[1]);

        int totalUsedCoins = 0;
        for (Integer currentCoin : coins.keySet()) {
            int occurrence = sum / currentCoin;

            coins.put(currentCoin, occurrence);
            totalUsedCoins += occurrence;
            sum -= occurrence * currentCoin;
        }

        if (sum > 0){
            System.out.println("Error!");
            return;
        }

        System.out.println("Number of coins to take: " + totalUsedCoins);
        coins.entrySet().stream()
                .filter(x -> x.getValue() != 0)
                .forEach(x -> System.out.println(String.format("%d coin(s) with value %d", x.getValue(), x.getKey())));
    }
}
