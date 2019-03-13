package P05_Jedi_Galaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            int[] dimestions = Arrays.stream(scanner.nextLine()
                    .split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int rows = dimestions[0];
            int cols = dimestions[1];

            Galaxy galaxy = new Galaxy(rows, cols);
            StarsManipulator starsManipulator = new StarsManipulator(galaxy);


            long sum = 0;
            while (true){
                String line = scanner.nextLine();
                if (line.equals("Let the Force be with you")){
                    break;
                }
                int[] playerPos = Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

                int[] evilPos = Arrays.stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

                int evilRow = evilPos[0];
                int evilCol = evilPos[1];

                starsManipulator.destroyStars(evilRow, evilCol);
              sum += starsManipulator.collectStars(playerPos);

            }
        System.out.println(sum);
    }
}
