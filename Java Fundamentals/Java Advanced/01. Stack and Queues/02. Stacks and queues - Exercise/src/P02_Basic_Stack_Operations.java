import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P02_Basic_Stack_Operations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];
        int S = input[1];
        int X = input[2];

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        String[] temp = scanner.nextLine().split("\\s+");
        int[] numbers = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            numbers[i] = Integer.parseInt(temp[i]);
        }

        for (int i = 0; i < N; i++) {
            stack.push(numbers[i]);
        }
        for (int i = 0; i < S; i++) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            System.out.println("0");
            return;
        } else if (stack.contains(X)) {
            System.out.println("true");
        } else {
            final int[] min = {Integer.MAX_VALUE};
            stack.forEach(x -> {
                if (x < min[0]) {
                    min[0] = x;
                }
            });
            System.out.println(min[0]);
        }
    }
}
