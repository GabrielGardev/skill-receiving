import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P04_Maximal_Sum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String [] input = reader.readLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int[] arr = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = arr;
        }

        int maxSum = Integer.MIN_VALUE;
        int[] bestSubmatrix = new int[9];

        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int sum = GetSumFromTopLeft(row, col, matrix);

                if (sum > maxSum){
                    maxSum = sum;

                    int[] a = new int[] {matrix[row][col],
                            matrix[row][col + 1],
                            matrix[row][col + 2],
                            matrix[row + 1][col],
                            matrix[row + 1][col + 1],
                            matrix[row + 1][col + 2],
                            matrix[row + 2][col],
                            matrix[row + 2][col + 1],
                            matrix[row + 2][col + 2]

                    };

                    bestSubmatrix = a;
                }
            }
        }
        System.out.println(String.format("Sum = %d", maxSum));
        for (int i = 0; i < bestSubmatrix.length; i++) {
            if (i % 3 == 0 && i != 0){
                System.out.println();
            }
            System.out.print(bestSubmatrix[i] + " ");
        }
    }
    private static int GetSumFromTopLeft(int row, int col, int[][] matrix) {
        return matrix[row][col] + matrix[row][col + 1] + matrix[row + 1][col] + matrix[row + 1][col + 1] +
                matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2] +
                matrix[row][col + 2] + matrix[row + 1][col + 2];
    }
}
