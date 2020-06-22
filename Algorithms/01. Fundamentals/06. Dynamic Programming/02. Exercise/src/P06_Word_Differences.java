import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P06_Word_Differences {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[] first = reader.readLine().toCharArray();
        char[] second = reader.readLine().toCharArray();

        int[][] dp = new int[first.length + 1][second.length + 1];

        for (int i = 0; i <= first.length; i++) {
            for (int j = 0; j <= second.length; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (first[i - 1] == second[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }

        System.out.println("Deletions and Insertions: " + dp[first.length][second.length]);
    }
}
