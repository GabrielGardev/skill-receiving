import java.util.Scanner;

public class P3_Recursive_Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int index = Integer.parseInt(scanner.nextLine());
        System.out.println(fibonacci(index));
    }
    static long fibonacci(int n)  {
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
