import java.util.Scanner;

public class P4_Floating_Equality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double numberA = Double.parseDouble(scanner.nextLine());
        double numberB = Double.parseDouble(scanner.nextLine());
        double dif = Math.abs(numberA - numberB);

        double eps = 0.000001;

        boolean isEqual = false;

        if (dif < eps)
        {
            isEqual = true;
        }

        String result = isEqual + "";
        result = (result.charAt(0) + "").toUpperCase() + result.substring(1);
        System.out.println(result);
    }
}
