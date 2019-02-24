import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P04_The_Matrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        char[][] matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = reader.readLine().replaceAll("\\s+", "").toCharArray();
        }

        char fillChar = reader.readLine().charAt(0);

        int [] startPosition = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        char oldChar = matrix[startPosition[0]][startPosition[1]];

        replaceMatrix(matrix, fillChar, oldChar, startPosition[0], startPosition[1]);

        printMatrix(matrix);
    }
    private static void printMatrix(char[][] matrix) {

        for (char[] matrix1 : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix1[j]);
            }
            System.out.println();
        }
    }

    private static void replaceMatrix(char[][] matrix, char fillChar, char oldChar, int row, int col) {

        if (outOfBounds(matrix, row, col) || matrix[row][col] != oldChar) {
            return;
        }

        matrix[row][col] = fillChar;

        replaceMatrix(matrix, fillChar,oldChar, row + 1, col);
        replaceMatrix(matrix, fillChar,oldChar, row - 1, col);
        replaceMatrix(matrix, fillChar,oldChar, row, col + 1);
        replaceMatrix(matrix, fillChar,oldChar, row, col - 1);
    }

    private static boolean outOfBounds(char[][] matrix, int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length;
    }
}
