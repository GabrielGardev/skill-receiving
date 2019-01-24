import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P12_The_Matrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String [] arr = reader.readLine().split(" ");
        int rows = Integer.parseInt(arr[0]);
        int cols = Integer.parseInt(arr[1]);

        char[][] matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] temp = reader.readLine().split(" ");
            for (int j = 0; j < cols; j++) {
                char currentChar = temp[j].charAt(0);
                matrix[i][j] = currentChar;
            }
        }

        char fillChar = reader.readLine().charAt(0);

        String [] coordinates = reader.readLine().split(" ");
        int x = Integer.parseInt(coordinates[0]);
        int y = Integer.parseInt(coordinates[1]);
        char originalValue = matrix[x][y];

        floodFill(y, x, originalValue, fillChar, matrix);
        printMatrix(matrix);
    }

    private static void floodFill(int y, int x, char originalValue, char fillChar, char[][] matrix) {
        int maxX = matrix.length - 1;
        int maxY = matrix[0].length - 1;
        int[][] stack = new int[(maxX + 1) * (maxY + 1)][2];
        int index = 0;

        stack[0][0] = x;
        stack[0][1] = y;
        matrix[x][y] = fillChar;

        while (index >= 0) {
            x = stack[index][0];
            y = stack[index][1];
            index--;

            if ((x > 0) && (matrix[x - 1][y] == originalValue)) {
                matrix[x - 1][y] = fillChar;
                index++;
                stack[index][0] = x - 1;
                stack[index][1] = y;
            }

            if ((x < maxX) && (matrix[x + 1][y] == originalValue)) {
                matrix[x + 1][y] = fillChar;
                index++;
                stack[index][0] = x + 1;
                stack[index][1] = y;
            }

            if ((y > 0) && (matrix[x][y - 1] == originalValue)) {
                matrix[x][y - 1] = fillChar;
                index++;
                stack[index][0] = x;
                stack[index][1] = y - 1;
            }

            if ((y < maxY) && (matrix[x][y + 1] == originalValue)) {
                matrix[x][y + 1] = fillChar;
                index++;
                stack[index][0] = x;
                stack[index][1] = y + 1;
            }
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
