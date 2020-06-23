import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P02_Cluster_Border {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int[] shipTimes = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] pairsTimes = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] dp = new int[shipTimes.length + 1];
        dp[1] = shipTimes[0];

        for (int i = 2; i <= shipTimes.length; i++) {
            dp[i] = Math.min(dp[i - 1] + shipTimes[i - 1], dp[i - 2] + pairsTimes[i - 2]);
        }

        sb.append("Optimal Time: ").append(dp[dp.length - 1]).append(System.lineSeparator());

        List<String> result = new ArrayList<>();

        for (int i = dp.length - 1; i > 0 ; i--) {
            int timeDiffForLatestTwo = dp[i] - dp[i - 1];
            if (timeDiffForLatestTwo == shipTimes[i - 1]){
                result.add("Single " + i);
            }else {
                result.add(String.format("Pair of %d and %d", i - 1, i));
                i--;
            }
        }

        for (int i = result.size() - 1; i >= 0; i--) {
            sb.append(result.get(i)).append(System.lineSeparator());
        }

        System.out.println(sb.toString());
    }
}
