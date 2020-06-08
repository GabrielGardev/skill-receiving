import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P6_Connected_Areas_in_a_Matrix {
    public static char[][] matrix;
    public static int counter = 0;
    public static List<int[]> list = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int rows = Integer.parseInt(reader.readLine());
        int cols = Integer.parseInt(reader.readLine());
        matrix = new char[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = reader.readLine().toCharArray();
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (isFree(row, col)){
                    findAreas(row, col);

                    int[] ints = new int[3];
                    ints[0] = row;
                    ints[1] = col;
                    ints[2] = counter;

                    list.add(ints);
                    counter = 0;
                }
            }
        }
        printResult();
    }

    private static void printResult() {
        StringBuilder sb = new StringBuilder();
        sb.append("Total areas found: ").append(list.size()).append(System.lineSeparator());

        list.stream()
                .sorted((f, s) -> Integer.compare(s[2], f[2]))
                .forEach(currentArr -> sb.append("Area #").append(++counter).append(" at (")
                        .append(currentArr[0])
                        .append(", ")
                        .append(currentArr[1])
                        .append("), size: ")
                        .append(currentArr[2])
                        .append(System.lineSeparator()));

        System.out.println(sb);
    }

    private static void findAreas(int row, int col) {
        if (isOutOfBounds(row, col) || isNotTraversal(row, col)){
            return;
        }

        matrix[row][col] = 'V';
        counter++;

        findAreas(row, col + 1);
        findAreas(row + 1, col);
        findAreas(row - 1, col);
        findAreas(row, col - 1);
    }

    private static boolean isNotTraversal(int row, int col) {
        return matrix[row][col] == '*' || matrix[row][col] == 'V';
    }

    private static boolean isOutOfBounds(int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }

    private static boolean isFree(int row, int col) {
        return matrix[row][col] == '-';
    }
}
