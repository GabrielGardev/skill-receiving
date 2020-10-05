import java.util.Arrays;

public class Recursion101 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(6, 19)));
    }

    public static int[] solve(int a, int b) {
        return a == 0 || b == 0 ? new int[]{a, b} :
                a >= 2 * b ? solve(a - 2 * b, b) :
                        b >= 2 * a ? solve(a, b - 2 * a) : new int[]{a, b};
    }
}
