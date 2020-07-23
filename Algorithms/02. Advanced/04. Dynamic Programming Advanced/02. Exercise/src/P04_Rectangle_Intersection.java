import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P04_Rectangle_Intersection {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int[][] matrix = new int[2000][2000];

        for (int i = 0; i < n; i++) {
            int[] coordinates = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int minX = coordinates[0] + 1000;
            int maxX = coordinates[1] + 1000;
            int minY = coordinates[2] + 1000;
            int maxY = coordinates[3] + 1000;

            for (int x = minX; x < maxX; x++) {
                for (int y = minY; y < maxY; y++) {
                    matrix[y][x] += 1;
                }
            }
        }
        int result = 0;

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if (anInt > 1) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
