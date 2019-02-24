import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P02_Recursive_Factorial {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        System.out.println(fac(n));
    }

    private static int fac(int n) {
        if (n == 1){
            return 1;
        }

        return n * fac(n - 1);
    }
}
