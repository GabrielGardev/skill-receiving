import java.util.Arrays;
import java.util.Scanner;

public class P2_From_Left_to_The_Right {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            long[] number = Arrays
                    .stream(scanner.nextLine()
                    .split(" "))
                    .mapToLong(Long::parseLong)
                    .toArray();

            if (number[0] > number[1]){
                SumDigits(number[0]);
            }else {
                SumDigits(number[1]);
            }
        }
    }

    static void SumDigits(long num) {
        num = Math.abs(num);
        int sum = 0;
        while (num != 0){
            sum += num % 10;
            num /= 10;
        }
        System.out.println(sum);
    }
}
