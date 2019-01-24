import java.util.Scanner;

public class P5_Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());

        printThePrice(product, quantity);
    }

//    coffee – 1.50
//    water – 1.00
//    coke – 1.40
//    snacks – 2.00

    private static void printThePrice(String product, int quantity) {
        switch (product) {
            case "coffee":
                System.out.printf("%.2f", 1.50 * quantity);
                break;
            case "water":
                System.out.printf("%.2f", 1.00 * quantity);
                break;
            case "coke":
                System.out.printf("%.2f", 1.40 * quantity);
                break;
            case "snacks":
                System.out.printf("%.2f", 2.00 * quantity);
                break;
        }
    }
}
