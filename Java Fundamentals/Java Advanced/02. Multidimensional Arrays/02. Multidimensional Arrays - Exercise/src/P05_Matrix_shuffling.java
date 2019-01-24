import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P05_Matrix_shuffling {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] line = reader.readLine().split(" ");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = line[j];
            }
        }

        while (true) {
            String[] line = reader.readLine().split(" ");
            if ("END".equals(line[0])) {
                break;
            }

            if (line.length == 5 && line[0].equals("swap")) {
                try {
                    int row1 = Integer.parseInt(line[1]);
                    int col1 = Integer.parseInt(line[2]);
                    int row2 = Integer.parseInt(line[3]);
                    int col2 = Integer.parseInt(line[4]);

                    String temp = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = temp;

                    printMatrix(matrix);
                } catch (Exception e) {
                    System.out.println("Invalid input!");
                    continue;
                }
            } else {
                System.out.println("Invalid input!");
            }
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
