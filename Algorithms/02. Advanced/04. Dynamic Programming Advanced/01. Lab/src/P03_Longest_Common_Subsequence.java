import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class P03_Longest_Common_Subsequence {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String first = reader.readLine();
        String second = reader.readLine();

        int[][] dp = new int[first.length() + 1][second.length() + 1];

        for (int rowIndex = 1; rowIndex <= first.length(); rowIndex++) {
            for (int colIndex = 1; colIndex <= second.length(); colIndex++) {
                if (first.charAt(rowIndex - 1) == second.charAt(colIndex - 1)) {
                    dp[rowIndex][colIndex] = dp[rowIndex - 1][colIndex - 1] + 1;
                } else {
                    dp[rowIndex][colIndex] = Math.max(dp[rowIndex - 1][colIndex], dp[rowIndex][colIndex - 1]);
                }
            }
        }

        System.out.println(dp[first.length()][second.length()]);

        int row = first.length() - 1;
        int col = second.length() - 1;

        String lcs = retrieveLCS(row, col, first, second, dp);

        System.out.println(lcs);
    }

    private static String retrieveLCS(int row, int col, String first, String second, int[][] dp) {

        List<Character> lcsLetters = new ArrayList<>();

        while (row >= 0 && col >= 0) {
            if (first.charAt(row) == second.charAt(col)) {
                lcsLetters.add(first.charAt(row));
                row--;
                col--;
            } else if (row > 0 && col == 0) {
                row--;
            } else if (row == 0 && col > 0) {
                col--;
            } else if (dp[row - 1][col] > dp[row][col - 1]) {
                row--;
            } else {
                col--;
            }
        }

        Collections.reverse(lcsLetters);
        return lcsLetters.stream().map(c -> c + "").collect(Collectors.joining());
    }
}