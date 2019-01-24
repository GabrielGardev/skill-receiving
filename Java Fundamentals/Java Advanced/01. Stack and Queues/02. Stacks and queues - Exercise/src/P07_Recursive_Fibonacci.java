import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class P07_Recursive_Fibonacci {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());

        System.out.println(fibonacci(num + 1));

    }

    public static long[] fib = new long[51];

    public static long fibonacci(int i) {
        if (i == 0) return 0;
        if (i <= 2) return 1;

        if (fib[i] != 0) {
            return fib[i];
        }

        fib[i] = fibonacci(i - 1) + fibonacci(i - 2);
        return fib[i];
    }
}
