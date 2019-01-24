import java.util.Scanner;

public class P6_Calculate_Rectangle_Area {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = Double.parseDouble(scanner.nextLine());
        double b = Double.parseDouble(scanner.nextLine());

        System.out.printf("%.0f", CalculateArea(a, b));
    }

    private static double CalculateArea(double a, double b) {

        return a * b;

    }
}
