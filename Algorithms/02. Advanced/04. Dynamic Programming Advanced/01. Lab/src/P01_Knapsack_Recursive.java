import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P01_Knapsack_Recursive {
    public static List<Integer> weights = new ArrayList<>();
    public static List<Integer> prices = new ArrayList<>();
    public static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int capacity = Integer.parseInt(reader.readLine());

        String line;

        while (!(line = reader.readLine()).equals("end")) {
            String[] tokens = line.split("\\s+");
            weights.add(Integer.parseInt(tokens[1]));
            prices.add(Integer.parseInt(tokens[2]));
        }

        dp = new int[prices.size() + 1][capacity + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int result = recurrence(0, 0, capacity);

        System.out.println(result);
    }

    private static int recurrence(int priceIndex, int weightIndex, int capacity) {

        if (priceIndex >= prices.size() || weightIndex >= weights.size() || weights.get(weightIndex) > capacity) {
            return 0;
        }

        if (dp[priceIndex][capacity] != -1) {
            return dp[priceIndex][capacity];
        }

        return dp[priceIndex][capacity] = Math.max(recurrence(priceIndex + 1, weightIndex + 1, capacity),
                recurrence(priceIndex + 1, weightIndex + 1, capacity - weights.get(weightIndex)) + prices.get(priceIndex));
    }
}
