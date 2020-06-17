import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01_Fibonacci {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        System.out.println(fib(n));
    }

    static long fib(int n) {
        double phi = (1 + Math.sqrt(5)) / 2;
        return Math.round(Math.pow(phi, n) / Math.sqrt(5));
    }
}
