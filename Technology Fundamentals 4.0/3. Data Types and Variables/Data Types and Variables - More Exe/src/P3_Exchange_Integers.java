import java.util.Scanner;

public class P3_Exchange_Integers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        System.out.printf("Before:\n a = %d\n b = %d\n", a, b);

        int temp = a;
        a = b;
        b = temp;

        System.out.printf("After:\n a = %d\n b = %d\n", a, b);
    }
}
