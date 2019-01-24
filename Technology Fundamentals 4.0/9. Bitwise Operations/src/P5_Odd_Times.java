import java.util.Arrays;
import java.util.Scanner;

public class P5_Odd_Times {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        var result = 0;

        for (int number : numbers) {
            result = result ^ number;
        }
        System.out.println(result);
    }
}
