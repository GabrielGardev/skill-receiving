import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P05_Sum_with_Limited_Amount_of_Coins {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] coins = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = Integer.parseInt(reader.readLine());
        int comb = findCombinations(coins, sum);

        System.out.println(comb);
    }

    public static int findCombinations(int[] coins, int sum) {
        int[][] maxCount = new int[coins.length + 1][sum + 1];

        for (int i = 0; i <= coins.length; i++) {
            maxCount[i][0] = 1;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = sum; j >= 0; j--) {
                if (coins[i - 1] <= j && maxCount[i - 1][j - coins[i - 1]] != 0) {
                    maxCount[i][j]++;
                } else {
                    maxCount[i][j] = maxCount[i - 1][j];
                }
            }
        }

        int count = 0;

        for (int i = 0; i <= coins.length; i++) {
            if (maxCount[i][sum] != 0) {
                count++;
            }
        }

        return count;
    }
}
