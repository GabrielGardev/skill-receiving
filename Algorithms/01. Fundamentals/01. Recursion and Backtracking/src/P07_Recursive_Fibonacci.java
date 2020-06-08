import java.util.Scanner;

public class P07_Recursive_Fibonacci {
    public static long[] fib = new long[51];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(getFibonacci(n));
    }

    private static long getFibonacci(int n) {
        if (n <= 1) {
            return 1;
        }
        
        if (fib[n] != 0){
            return fib[n];
        }

        fib[n] = getFibonacci(n - 1) + getFibonacci(n - 2);
        return fib[n];
    }
}
