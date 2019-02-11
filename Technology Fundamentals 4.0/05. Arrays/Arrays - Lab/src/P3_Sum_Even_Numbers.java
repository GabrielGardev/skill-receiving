import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class P3_Sum_Even_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int sum = 0;

        for (var num : numbers) {
            if (num % 2 == 0){
                sum += num;
            }
        }
        System.out.println(sum);
    }
}
