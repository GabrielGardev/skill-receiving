import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P03_Maximum_Element {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        ArrayDeque<Long> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            long[] line = Arrays.stream(reader.readLine().split("\\s+")).mapToLong(Long::parseLong).toArray();
            long command = line[0];

            if (command == 1){
                long num = line[1];
                stack.push(num);
            }else if (command == 2){
                stack.pop();
            }else {
                final long[] max = {Long.MIN_VALUE};
                stack.forEach(x -> {
                    if (x > max[0]){
                        max[0] = x;
                    }
                });
                System.out.println(max[0]);
            }
        }
    }
}
