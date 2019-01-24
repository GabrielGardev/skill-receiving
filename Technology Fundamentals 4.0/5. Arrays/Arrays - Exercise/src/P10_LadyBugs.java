import java.util.Arrays;
import java.util.Scanner;

public class P10_LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeOfTheField = Integer.parseInt(scanner.nextLine());
        int[] field = new int[sizeOfTheField];

        String[] indexes = scanner.nextLine().split(" ");

        for (int i = 0; i < indexes.length; i++) {
            int index = Integer.parseInt(indexes[i]);
            if (index < field.length && index >= 0) {
                field[index] = 1;
            }
        }

        while (true) {
            String[] command = scanner.nextLine().split(" ");
            if (command[0].equals("end")) {
                break;
            }

            int ladybugIndex = Integer.parseInt(command[0]);
            String direction = command[1];
            int flyLenght = Integer.parseInt(command[2]);


            if (ladybugIndex > sizeOfTheField - 1 || ladybugIndex < 0 || field[ladybugIndex] == 0) {
                continue;
            }

            field[ladybugIndex] = 0;

            if (direction.equals("right")) {
                ladybugIndex += flyLenght;
                while (ladybugIndex < sizeOfTheField && field[ladybugIndex] == 1){
                    ladybugIndex += flyLenght;
                }
                if (ladybugIndex < sizeOfTheField){
                    field[ladybugIndex] = 1;
                }

            } else if (direction.equals("left")){
                ladybugIndex -= flyLenght;
                while (ladybugIndex >= 0 && field[ladybugIndex] == 1){
                    ladybugIndex -= flyLenght;
                }
                if (ladybugIndex >= 0){
                    field[ladybugIndex] = 1;
                }
            }
        }
        for (int i = 0; i < sizeOfTheField; i++) {
            System.out.print(field[i] + " ");
        }
    }
}
