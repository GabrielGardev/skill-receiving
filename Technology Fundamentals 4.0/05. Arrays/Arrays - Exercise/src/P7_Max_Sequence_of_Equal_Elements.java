import java.util.Arrays;
import java.util.Scanner;

public class P7_Max_Sequence_of_Equal_Elements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int length = 1, maxLength = 0;
        String number = "";

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1]){
                length++;
            }else {
                length = 1;
            }

            if (length > maxLength){
                maxLength = length;
                number = numbers[i] + " ";
            }
        }
        for (int i = 0; i < maxLength; i++) {
            System.out.print(number);
        }
    }
}
