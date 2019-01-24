import javafx.print.Collation;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P6_Reversed_Chars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Character[] symbols = new Character[3];

        for (int i = 0; i < 3; i++) {
            symbols[i] = scanner.nextLine().charAt(0);
        }

        for (int i = 2; i >= 0; i--) {
            System.out.print(symbols[i] + " ");
        }

    }
}
