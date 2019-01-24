import java.util.Scanner;

public class P5_Refactoring_Prime_Checker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        for (int i = 2; i <= num; i++) {
            boolean itIsPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    itIsPrime = false;
                    break;
                }
            }
            System.out.printf("%d -> %b%n", i, itIsPrime);

        }
    }
}
