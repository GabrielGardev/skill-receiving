import java.util.Scanner;

public class P7_Lower_or_Upper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char symbol = scanner.nextLine().charAt(0);

        if (symbol >= 65 && symbol <= 90)
        {
            System.out.println("upper-case");
        }
        else
        {
            System.out.println("lower-case");
        }
    }
}
