import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P03_Move_Down_Right {
    public static int[][] matrix;
    public static int[][] dp;
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static List<int[]> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        int r = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        fillMatrix(r, c);

        sumFirstRow(c);
        sumFirstCol(r);

        sumCells();
        getPath(r - 1, c - 1, dp[0][0]);
        result.add(new int[] {0, 0});

        print();
    }

    private static void getPath(int row, int col, int end) {
        if (!isInBounds(row, col) || dp[row][col] == end){
            return;
        }

        int[] pair = new int[] {row, col};
        result.add(pair);

        if (isInBounds(row, col - 1) && isInBounds(row - 1, col)){
            if (dp[row][col - 1] >= dp[row - 1][col]){
                //go left
                getPath(row, col - 1, end);
            }else {
                //go up
                getPath(row - 1, col, end);
            }
        }else if (isInBounds(row, col - 1)){
            //go left
            getPath(row, col - 1, end);
        }else if (isInBounds(row - 1, col)){
            //go up
            getPath(row - 1, col, end);
        }
    }

    private static void sumCells() {
        for (int row = 1; row < dp.length; row++) {
            for (int col = 1; col < dp[row].length; col++) {
                int max = Math.max(dp[row - 1][col] + matrix[row][col], dp[row][col - 1] + matrix[row][col]);
                dp[row][col] = max;
            }
        }
    }

    private static void print() {
        Collections.reverse(result);
        for (int[] ints : result) {
            System.out.printf("[%d, %d] ", ints[0], ints[1]);
        }
    }

    private static void sumFirstCol(int rows) {
        for (int row = 1; row < rows; row++) {
            dp[row][0] = dp[row - 1][0] + matrix[row][0];
        }
    }

    private static void sumFirstRow(int cols) {
        for (int col = 1; col < cols; col++) {
            dp[0][col] = dp[0][col - 1] + matrix[0][col];
        }
    }

    private static boolean isInBounds(int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static void fillMatrix(int r, int c) throws IOException {
        matrix = new int[r][c];

        for (int i = 0; i < r; i++) {
            matrix[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        dp = new int[r][c];
        dp[0][0] = matrix[0][0];
    }
}
