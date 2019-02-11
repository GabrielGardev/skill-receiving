import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P1_Sort_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] numbers = new Integer[3];

        for (int i = 0; i < 3; i++) {
            Integer number = Integer.parseInt(scanner.nextLine());

            numbers[i] = number;
        }

        Arrays.sort(numbers, Collections.reverseOrder());
        for (var num : numbers) {
            System.out.println(num);
        }
    }
}
