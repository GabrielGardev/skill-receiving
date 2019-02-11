import java.math.BigInteger;
import java.util.Scanner;

public class P1_Data_Type_Finder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        while (true) {
            String command = scanner.nextLine();

            if (command.equals("END")) {
                return;
            }

            try {
                BigInteger intType = new BigInteger(command);
                System.out.printf("%s is integer type\n", command);
                continue;
            } catch (Exception e) {

            }

            try {
                double doubleType = Double.parseDouble(command);
                System.out.printf("%s is floating point type\n", command);
                continue;
            } catch (Exception e) {

            }

            if (command.toLowerCase().equals("false") || command.toLowerCase().equals("true")) {
                System.out.printf("%s is boolean type\n", command);
                continue;
            }

            if (command.length() == 1) {
                System.out.printf("%s is character type\n", command);
            } else if (command.length() > 1) {
                System.out.printf("%s is string type\n", command);
            }
        }
    }
}
