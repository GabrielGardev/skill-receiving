import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P08_Minimum_Edit_Distance {
    public static int replaceCost;
    public static int insertCost;
    public static int deleteCost;
    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        replaceCost = Integer.parseInt(reader.readLine());
        insertCost= Integer.parseInt(reader.readLine());
        deleteCost= Integer.parseInt(reader.readLine());

        char[] first = reader.readLine().toCharArray();
        char[] second = reader.readLine().toCharArray();

        compute(first, second);
    }
    private static void compute(char[] first, char[] second) {

        int firstLen = first.length;
        int secondLen = second.length;

        dp = new int[firstLen + 1][secondLen + 1];

        for (int row = 0; row <= firstLen; row++) {
            dp[row][0] = row * deleteCost;
        }

        for (int col = 0; col <= secondLen; col++) {
            dp[0][col] = col * insertCost;
        }

        for (int row = 1; row <= firstLen; row++) {
            for (int col = 1; col <= secondLen; col++) {

                int cost = second[col - 1] == first[row - 1] ? 0 : replaceCost;

                int delete = dp[row - 1][col] + deleteCost;
                int replace = dp[row - 1][col - 1] + cost;
                int insert = dp[row][col - 1] + insertCost;

                dp[row][col] = Math.min(Math.min(delete, insert), replace);
            }
        }

        System.out.println("Minimum edit distance: " + dp[firstLen][secondLen]);
    }
}
