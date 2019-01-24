import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P05_Maximum_Sum_of_2x2_Submatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String [] input = reader.readLine().split(", ");
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);

        int[][] matrix = new int[row][col];

        for (int i = 0; i < row; i++) {
            int[] arr = Arrays.stream(reader.readLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = arr;
        }
        int maxSum = Integer.MIN_VALUE;
        int[] bestSubmatrix = new int[4];
        for (int i = 0; i < row - 1; i++) {
            for (int j = 0; j < col - 1; j++) {
                int sum = GetSumFromTopLeft(i, j, matrix);
                if (sum > maxSum){
                    maxSum = sum;

                    int[] a = new int[] {matrix[i][j],
                            matrix[i][j + 1],
                            matrix[i + 1][j],
                            matrix[i + 1][j + 1]
                    };

                    bestSubmatrix = a;
                }

            }
        }
        System.out.println(String.format("%d %d\n%d %d\n%d\n", bestSubmatrix[0], bestSubmatrix[1],
                bestSubmatrix[2],
                bestSubmatrix[3],
                maxSum));
    }

    private static int GetSumFromTopLeft(int row, int col, int[][] matrix) {
        return matrix[row][col] + matrix[row][col + 1] + matrix[row + 1][col] + matrix[row + 1][col + 1];
    }
}
