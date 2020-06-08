import java.io.IOException;
import java.util.Scanner;

public class P02_Recursive_Drawing {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        printFigure(n);
    }

    private static void printFigure(int n) {
        if (n == 0){
            return;
        }
        printLineOfChars('*', n);
        printFigure(n - 1);
        printLineOfChars('#', n);
    }

    private static void printLineOfChars(char symbol, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(symbol);
        }
        System.out.println();
    }
}
