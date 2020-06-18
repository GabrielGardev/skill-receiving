import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01_Binomial_Coefficients {
    public static long[][] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());
        memo = new long[n+ 1][k + 1];

        System.out.println(binom(n, k));
    }

    private static long binom(int n, int k) {
        if (k > n) {return 0;}
        if (k == 0 || k == n) {return 1;}

        if (memo[n][k] != 0){
            return memo[n][k];
        }

        return memo[n][k] = binom(n-1, k) + binom(n-1, k-1);
    }
}
