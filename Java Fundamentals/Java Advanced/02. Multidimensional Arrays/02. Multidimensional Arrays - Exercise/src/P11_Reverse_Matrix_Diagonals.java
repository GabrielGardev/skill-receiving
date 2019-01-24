import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P11_Reverse_Matrix_Diagonals {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] dimension = Arrays.stream(reader.readLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimension[0];
        int cols = dimension[1];
        int[][] matrix = new int[rows][cols];
        fillMatrix(matrix, rows, reader);

        int row = rows - 1;
        int col = cols - 1;

        while (row != -1) {
            int c = col;
            int r = row;

            while (c < dimension[1] && r >= 0) {
                System.out.print(matrix[r--][c++] + " ");
            }

            System.out.println();
            col--;

            if (col == -1) {
                col = 0;
                row--;
            }
        }
    }

    private static void fillMatrix(int[][] matrix, int rows, BufferedReader reader) throws IOException {

        for (int i = 0; i < rows; i++) {

            matrix[i] = Arrays.stream(reader.readLine()
                    .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}