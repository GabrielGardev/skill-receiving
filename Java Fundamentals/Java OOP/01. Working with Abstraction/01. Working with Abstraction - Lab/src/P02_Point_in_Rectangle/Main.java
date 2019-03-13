package P02_Point_in_Rectangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] coordinates = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Point point1 = new Point(coordinates[0], coordinates[1]);
        Point point2 = new Point(coordinates[2], coordinates[3]);

        Rectangle rectangle = new Rectangle(point1, point2);

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            int[] newPointCoord = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            Point point = new Point(newPointCoord[0], newPointCoord[1]);
            System.out.println(rectangle.Contains(point));
        }
    }
}
