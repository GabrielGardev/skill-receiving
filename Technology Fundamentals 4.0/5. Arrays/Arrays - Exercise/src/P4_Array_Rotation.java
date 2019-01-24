import java.util.Arrays;
import java.util.Scanner;

public class P4_Array_Rotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = Integer.parseInt(scanner.nextLine());

        int rotations = n % numbers.length;

        for (int i = 0; i < rotations; i++) {
            int firstNum = numbers[0];
            for (int j = 0; j < numbers.length - 1; j++) {
                numbers[j] = numbers[j + 1];
            }
            numbers[numbers.length - 1] = firstNum;
        }
        for (var num : numbers) {
            System.out.print(num + " ");
        }

    }
}
