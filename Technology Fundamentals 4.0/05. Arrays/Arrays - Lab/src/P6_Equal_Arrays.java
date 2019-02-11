import java.util.Arrays;
import java.util.Scanner;

public class P6_Equal_Arrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] first = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] second = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int sum = 0;
        int maxLenght = Math.max(first.length, second.length);
        for (int i = 0; i < maxLenght; i++) {
            if (first[i] != second[i]){
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                return;
            }
            sum += first[i];
        }
        System.out.printf("Arrays are identical. Sum: %d", sum);
    }
}
