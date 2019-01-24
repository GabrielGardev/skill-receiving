import java.util.Scanner;

public class P2_Center_Point {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int X1 = Integer.parseInt(scanner.nextLine());
        int Y1 = Integer.parseInt(scanner.nextLine());
        int X2 = Integer.parseInt(scanner.nextLine());
        int Y2 = Integer.parseInt(scanner.nextLine());

        if (GetClosePoint(X1, Y1) <= GetClosePoint(X2, Y2)) {
            System.out.printf("(%d, %d)", X1, Y1);
        } else {
            System.out.printf("(%d, %d)", X2, Y2);
        }
    }
    static double GetClosePoint(int X1, int Y1) {
        double d = Math.sqrt(Math.pow(X1, 2) + Math.pow(Y1, 2));
        return d;
    }
}

