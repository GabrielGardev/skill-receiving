import java.util.Arrays;
import java.util.Scanner;

public class P8_Magic_Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int serchingSum = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == serchingSum){
                    System.out.printf("%d %d", numbers[i], numbers[j]);
                    System.out.println();
                }
            }
        }
    }
}
