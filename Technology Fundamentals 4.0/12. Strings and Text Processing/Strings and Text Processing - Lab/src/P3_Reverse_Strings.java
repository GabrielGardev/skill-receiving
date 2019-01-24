import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P3_Reverse_Strings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){
            String line = scanner.nextLine();
            if (line.equals("end")){
                break;
            }
            StringBuilder result = new StringBuilder(line).reverse();

            System.out.println(String.format("%s = %s", line, result));
        }

    }
}
