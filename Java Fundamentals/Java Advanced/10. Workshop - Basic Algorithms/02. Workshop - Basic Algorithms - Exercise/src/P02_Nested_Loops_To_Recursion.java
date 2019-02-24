import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class P02_Nested_Loops_To_Recursion {
    private static int[] aar;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        aar = new int[n];
        int begin = 0;
        printNestedLoops(n, begin);
    }

    private static void printNestedLoops(int n, int begin) {

        if (begin >= n){
            Arrays.stream(aar).forEach(x -> System.out.print(x + " "));
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            aar[begin] = i;
            printNestedLoops(n , begin + 1);
        }


    }
}
