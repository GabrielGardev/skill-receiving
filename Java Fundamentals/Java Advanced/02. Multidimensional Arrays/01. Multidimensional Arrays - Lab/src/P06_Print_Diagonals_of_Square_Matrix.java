import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P06_Print_Diagonals_of_Square_Matrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            int[] arr = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = arr;
        }

        PrintTopLeftDiagonal(matrix);
        PrintBottomLeftDiagonal(matrix);
    }

    private static void PrintBottomLeftDiagonal(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            sb.append(matrix[matrix.length - 1 - i][i] + " ");
        }
        System.out.println(sb.toString());
    }

    private static void PrintTopLeftDiagonal(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            sb.append(matrix[i][i] + " ");
        }
        System.out.println(sb.toString());
    }
}
