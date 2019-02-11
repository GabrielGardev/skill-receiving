
import java.util.Scanner;


public class P5_Pounds_to_Dollars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double paund = Double.parseDouble(scanner.nextLine());
        double dolar = paund * 1.31;


        System.out.printf("%.3f", dolar);
    }
}
