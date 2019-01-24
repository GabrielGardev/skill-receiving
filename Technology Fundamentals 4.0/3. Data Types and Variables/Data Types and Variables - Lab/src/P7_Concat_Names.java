import java.util.Scanner;

public class P7_Concat_Names {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstName = scanner.nextLine();
        String secondName = scanner.nextLine();
        String delimeter = scanner.nextLine();

        System.out.println(String.format("%s%s%s", firstName, delimeter, secondName));
    }
}
