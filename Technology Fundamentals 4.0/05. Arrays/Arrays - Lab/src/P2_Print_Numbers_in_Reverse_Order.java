import java.util.Scanner;

public class P2_Print_Numbers_in_Reverse_Order {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] numbers = new String[n];

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            numbers[i] = input;
        }

        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.print(numbers[i] + " ");
        }
    }
}
