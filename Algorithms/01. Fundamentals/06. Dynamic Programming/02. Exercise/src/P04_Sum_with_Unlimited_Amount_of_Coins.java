import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P04_Sum_with_Unlimited_Amount_of_Coins {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] coins = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int targetSum = Integer.parseInt(reader.readLine());
        int[] dp = new int[targetSum + 1];

        dp[0] = 1;

        for (int coin : coins) {
            for (int j = coin; j <= targetSum; j++) {
                dp[j] += dp[j - coin];
            }
        }

        System.out.println(dp[targetSum]);
    }
}
