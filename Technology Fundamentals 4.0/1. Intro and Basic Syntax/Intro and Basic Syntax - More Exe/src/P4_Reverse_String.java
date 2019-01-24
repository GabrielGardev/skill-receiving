import java.util.Scanner;

public class P4_Reverse_String {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String output = new StringBuilder(input).reverse().toString();
        System.out.println(output);
    }
}
