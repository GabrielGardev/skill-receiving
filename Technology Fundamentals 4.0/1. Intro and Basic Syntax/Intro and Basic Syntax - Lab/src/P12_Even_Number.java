import java.util.Scanner;

public class P12_Even_Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Math.abs(Integer.parseInt(scanner.nextLine()));

        while (n % 2 != 0)
        {
            System.out.println("Please write an even number.");
            n = Math.abs(Integer.parseInt(scanner.nextLine()));
        }
        System.out.printf("The number is: %d", n);
    }
}
