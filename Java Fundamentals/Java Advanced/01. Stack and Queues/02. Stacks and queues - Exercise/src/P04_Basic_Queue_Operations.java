import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class P04_Basic_Queue_Operations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];
        int S = input[1];
        int X = input[2];

        ArrayDeque<Integer> deque = new ArrayDeque<>();


        int[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();;

        for (int i = 0; i < N; i++) {
            deque.offer(numbers[i]);
        }
        for (int i = 0; i < S; i++) {
            deque.poll();
        }

        if (deque.isEmpty()) {
            System.out.println("0");
            return;
        } else if (deque.contains(X)) {
            System.out.println("true");
        } else {
            final int[] min = {Integer.MAX_VALUE};
            deque.forEach(x -> {
                if (x < min[0]) {
                    min[0] = x;
                }
            });
            System.out.println(min[0]);
        }
    }
}
