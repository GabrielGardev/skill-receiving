import java.util.Scanner;

public class P3_Longer_Line {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double X1 = Double.parseDouble(scanner.nextLine());
        double Y1 = Double.parseDouble(scanner.nextLine());

        double X2 = Double.parseDouble(scanner.nextLine());
        double Y2 = Double.parseDouble(scanner.nextLine());

        double X3 = Double.parseDouble(scanner.nextLine());
        double Y3 = Double.parseDouble(scanner.nextLine());

        double X4 = Double.parseDouble(scanner.nextLine());
        double Y4 = Double.parseDouble(scanner.nextLine());

        double firstLine = lineLength(X1, Y1, X2, Y2);
        double secondLine = lineLength(X3, Y3, X4, Y4);

        if (firstLine >= secondLine) {
            if (GetClosePoint(X1, Y1) <= GetClosePoint(X2, Y2)) {
                System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", X1, Y1, X2, Y2);
            } else {
                System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", X2, Y2, X1, Y1);
            }
        } else {
            if (GetClosePoint(X3, Y3) <= GetClosePoint(X4, Y4)) {
                System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", X3, Y3, X4, Y4);
            } else {
                System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", X4, Y4, X3, Y3);
            }
        }
    }

    static double GetClosePoint(double X1, double Y1) {
        double d = Math.sqrt(Math.pow(X1, 2) + Math.pow(Y1, 2));
        return d;
    }
    static double lineLength (double X1, double Y1, double X2, double Y2)
    {
        return Math.sqrt(Math.pow((X2 - X1), 2) + Math.pow((Y2 - Y1), 2));
    }
}
