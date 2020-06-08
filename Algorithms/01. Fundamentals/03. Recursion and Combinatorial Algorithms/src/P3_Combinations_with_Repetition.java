import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P3_Combinations_with_Repetition {
    public static int[] numbs;
    public static int n;
    public static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        k = Integer.parseInt(reader.readLine());

        numbs = new int[k];

        comb(0, 1);
    }

    public static void comb(int index, int start) {
        if (index >= k) {
            print();
        } else {
            for (int i = start; i <= n; i++) {
                numbs[index] = i;
                comb(index + 1, i);
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
