import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class P03_Connected_Areas_in_a_Matrix {

   private static class Area {
        private int row;
        private int col;
        private int size;

        public Area(int row, int col, int size) {
            this.row = row;
            this.col = col;
            this.size = size;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        public int getSize() {
            return size;
        }

        public String toString(int num) {
            return String.format("Area #%d at (%d, %d), size: %d", num, this.row, this.col, this.size);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Area> areas = new ArrayList<>();

        int rows = Integer.parseInt(reader.readLine());
        int cols = Integer.parseInt(reader.readLine());

        char[][] matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = reader.readLine().replaceAll("\\s+", "").toCharArray();
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '-') {
                    int[] size = new int[1];
                    countArea(matrix, i, j, size);

                    Area area = new Area(i, j, size[0]);
                    areas.add(area);
                }
            }
        }
        System.out.printf("Total areas found: %d%n", areas.size());
        AtomicInteger counter = new AtomicInteger(1);

        areas.stream().sorted((a, b) -> {
            int result = Integer.compare(b.getSize(), a.getSize());

            if (result == 0) {
                result = Integer.compare(a.getRow(), b.getRow());
            }

            if (result == 0) {
                result = Integer.compare(a.getCol(), b.getCol());
            }
            return result;
        })
                .forEach(x -> System.out.println(x.toString(counter.getAndIncrement())));
    }

    private static void countArea(char[][] matrix, int row, int col, int[] size) {
        if (outOfBounds(matrix, row, col) || matrix[row][col] == '*') {
            return;
        }

        matrix[row][col] = '*';
        size[0]++;
        countArea(matrix, row + 1, col, size);
        countArea(matrix, row - 1, col, size);
        countArea(matrix, row, col + 1, size);
        countArea(matrix, row, col - 1, size);
    }

    private static boolean outOfBounds(char[][] matrix, int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length;
    }
}
