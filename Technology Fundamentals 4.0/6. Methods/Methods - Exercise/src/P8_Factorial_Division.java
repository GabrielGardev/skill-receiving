import java.util.Scanner;

public class P8_Factorial_Division {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        long firstSum = factorial(firstNum);
        long secondSum = factorial(secondNum);

        double result = (firstSum * 1.0) / (secondSum * 1.0);

        System.out.printf("%.2f", result);
    }
    public static long factorial(int number) {
        long result = 1;

        for (int factor = 2; factor <= number; factor++) {
            result *= factor;
        }

        return result;
    }
}
