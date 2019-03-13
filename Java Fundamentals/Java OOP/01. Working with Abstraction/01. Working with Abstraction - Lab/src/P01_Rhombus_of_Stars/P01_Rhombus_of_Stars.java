package P01_Rhombus_of_Stars;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01_Rhombus_of_Stars {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        for (int i = 1; i < n; i++) {
            printRow(n, i);
        }
        System.out.println(repeatStr("* ", n - 1) + "*");
        for (int i = n - 1; i > 0; i--) {
            printRow(n, i);
        }

    }

    private static void printRow(int n, int i) {
        System.out.print(repeatStr(" ", n - i));
        System.out.print(repeatStr("* ", i));
        System.out.println();
    }

    private static String repeatStr (String text, int count) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < count; i++) {
            result.append(text);
        }
        return result.toString();
    }
}
