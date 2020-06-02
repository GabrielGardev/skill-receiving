import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2_Nested_Loops_To_Recursion {
    public static int[] numbs;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        numbs = new int[n];

        permute(0);
    }

    private static void permute(int index) {
        if (index == n){
            print();
        }else {
            for (int i = 1; i <= n; i++) {
                numbs[index] = i;
                permute(index + 1);
            }
        }
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        for (int numb : numbs) {
            sb.append(numb).append(" ");
        }
        System.out.println(sb);
    }
}
