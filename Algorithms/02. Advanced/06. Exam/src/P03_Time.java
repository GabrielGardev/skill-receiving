import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class P03_Time {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] first = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] second = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] dp = new int[first.length + 1][second.length + 1];

        for (int rowIndex = 1; rowIndex <= first.length; rowIndex++) {
            for (int colIndex = 1; colIndex <= second.length; colIndex++) {
                if (first[rowIndex - 1] == second[colIndex - 1]) {
                    dp[rowIndex][colIndex] = dp[rowIndex - 1][colIndex - 1] + 1;
                } else {
                    dp[rowIndex][colIndex] = Math.max(dp[rowIndex - 1][colIndex], dp[rowIndex][colIndex - 1]);
                }
            }
        }


        int row = dp.length - 1;
        int col = dp[row].length - 1;

        String lcs = retrieveLCS(row, col, first, second, dp);

        System.out.println(lcs);
        System.out.println(dp[first.length][second.length]);
    }

    private static String retrieveLCS(int row, int col, int[] first, int[] second, int[][] dp) {
        List<Integer> lcsLetters = new ArrayList<>();

        while (row > 0 && col > 0) {
            if (first[row - 1] == second[col - 1]) {
                lcsLetters.add(first[row - 1]);
                row--;
                col--;
            } else if (dp[row - 1][col] > dp[row][col - 1]) {
                row--;
            } else {
                col--;
            }
        }

        Collections.reverse(lcsLetters);
        return lcsLetters.stream().map(c -> c + " ").collect(Collectors.joining());
    }
}