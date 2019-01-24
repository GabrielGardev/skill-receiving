import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P09_Parking_System {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] parkingDimensionsRolCol = InitializeParking(reader);
        HashSet<Cell> usedCells = new HashSet<Cell>();

        var input = reader.readLine().split(" ");

        while (!input[0].equals("stop")) {
            int carEntranceRow = Integer.parseInt(input[0]);
            Cell carParkingAim = new Cell();
            carParkingAim.Row = Integer.parseInt(input[1]);
            carParkingAim.Column = Integer.parseInt(input[2]);


            // Process car
            if (IsCarParked(carParkingAim, usedCells, parkingDimensionsRolCol)) {
                // Print distance travelled to the park
                System.out.println((Math.abs((carEntranceRow + 1) - (carParkingAim.Row + 1)) + carParkingAim.Column + 1));
                usedCells.add(carParkingAim);
            } else {
                System.out.println(String.format("Row %d full", carParkingAim.Row));
            }

            input = reader.readLine().split(" ");
        }

    }

    private static boolean IsCarParked(Cell carParkingAim, HashSet<Cell> usedCells, int[] parkingDimensionsRolCol) {
        if (usedCells.stream()
                .filter((cell) -> cell.Row == carParkingAim.Row && cell.Column == carParkingAim.Column)
                .findFirst()
                .orElse(null) == null) {
            return true;
        }

        int testCol = 1;

        // Loop around the row to find free cell to park
        while (true) {
            int leftCol = carParkingAim.Column - testCol;
            int rightCol = carParkingAim.Column + testCol;

            if (leftCol <= 0 && rightCol >= parkingDimensionsRolCol[1]) {
                break;
            }

            // Try park left
            if (leftCol > 0 &&
                    usedCells.stream().filter((c) -> c.Row == carParkingAim.Row && c.Column == leftCol)
                            .findFirst()
                            .orElse(null) == null) {
                carParkingAim.Column = leftCol;
                return true;
            }

            // Try park right
            if (rightCol < parkingDimensionsRolCol[1] &&
                    usedCells.stream().filter((c) -> c.Row == carParkingAim.Row && c.Column == rightCol)
                            .findFirst()
                            .orElse(null) == null) {
                carParkingAim.Column = rightCol;
                return true;
            }

            testCol++;
        }
        return false;
    }

    private static int[] InitializeParking(BufferedReader reader) throws IOException {
        var dimmensions = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        return new int[]{dimmensions[0], dimmensions[1]};
    }

    public static class Cell {
        public int Row;

        public int Column;

        public Cell() {
        }
    }
}
