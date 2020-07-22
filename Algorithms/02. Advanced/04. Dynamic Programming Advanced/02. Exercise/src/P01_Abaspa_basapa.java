import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class P01_Abaspa_basapa {
    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String first = reader.readLine();
        String second = reader.readLine();
        dp = new int[first.length()][second.length()];
        int bestLength = -1;
        int bestRow = -1;
        int bestCol = -1;

        for (int rowIndex = 0; rowIndex < first.length(); rowIndex++) {
            for (int colIndex = 0; colIndex < second.length(); colIndex++) {
                if (first.charAt(rowIndex) == second.charAt(colIndex)) {
                    dp[rowIndex][colIndex] = getPrevBest(rowIndex, colIndex) + 1;
                }

                if (dp[rowIndex][colIndex] > bestLength){
                    bestLength = dp[rowIndex][colIndex];
                    bestRow = rowIndex;
                    bestCol = colIndex;
                }
            }
        }

        List<Character> result = new ArrayList<>();

        while (bestRow >= 0 && bestCol >= 0 && dp[bestRow][bestCol] != 0){
            result.add(first.charAt(bestRow));
            bestRow--;
            bestCol--;
        }

        Collections.reverse(result);
        System.out.println(result.stream().map(c -> c + "").collect(Collectors.joining()));
    }

    private static int getPrevBest(int rowIndex, int colIndex) {
        if (rowIndex - 1 < 0 || colIndex - 1 < 0){
            return 0;
        } else {
            return dp[rowIndex - 1][colIndex - 1];
        }
    }
}
