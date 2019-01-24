import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class P07_Crossfire {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] dimensions = Arrays.stream(reader.readLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        fillMatrix(matrix, rows, cols);

        String line = reader.readLine();

        while (!"Nuke it from orbit".equals(line)) {

            int[] explosionData = Arrays.stream(line
                    .split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            destroyMatrix(matrix,explosionData, cols, rows);
            line = reader.readLine();
        }

        printMatrix(matrix);
    }

    private static void printMatrix(ArrayList<ArrayList<Integer>> matrix) {

        for (int i = 0; i < matrix.size(); i++) {

            for (int j = 0; j < matrix.get(i).size(); j++) {

                System.out.print(matrix.get(i).get(j) + " ");
            }

            System.out.println();
        }
    }

    private static void destroyMatrix(ArrayList<ArrayList<Integer>> matrix, int[] explosionData, int initialCols, int initialRows) {

        int row = explosionData[0];
        int col = explosionData[1];
        int radius = explosionData[2];

        int topRow = row - radius;
        int botRow = row + radius;
        int leftCol = col - radius;
        int rightCol = col + radius;

        if (radius == 0) {
            try {
                matrix.get(row).set(col, Integer.MIN_VALUE);

            } catch (Exception ex) {

            }
            clearMatrix(matrix);

            return;
        }

        if (row >= 0 && row < matrix.size()) {

            for (int i = Math.max(0, leftCol); i <= Math.min(initialCols, rightCol); i++) {

                try {
                    matrix.get(row).set(i, Integer.MIN_VALUE);
                } catch (Exception ex) {

                }
            }
        }

        if (col >= 0 && col < initialCols) {

            for (int i = Math.max(topRow, 0); i <= Math.min(botRow, initialRows); i++) {
                try {
                    matrix.get(i).set(col, Integer.MIN_VALUE);
                } catch (Exception ex) {

                }
            }
        }

        clearMatrix(matrix);
    }

    private static void clearMatrix(ArrayList<ArrayList<Integer>> matrix) {
        for (ArrayList<Integer> matrix1 : matrix) {
            matrix1.removeIf(e -> e == Integer.MIN_VALUE);
        }

        matrix.removeIf(ArrayList::isEmpty);
    }


    private static void fillMatrix(ArrayList<ArrayList<Integer>> matrix, int rows, int cols) {

        int counter = 1;

        for (int i = 0; i < rows; i++) {
            matrix.add(i, new ArrayList<>());
            for (int j = 0; j < cols; j++) {

                matrix.get(i).add(j, counter++);

            }
        }
    }
}