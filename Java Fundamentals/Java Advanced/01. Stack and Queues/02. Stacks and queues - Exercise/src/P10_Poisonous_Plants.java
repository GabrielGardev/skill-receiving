import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class P10_Poisonous_Plants {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[] plants = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] days = new int[plants.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        for (int i = 1; i < plants.length; i++) {
            int maxDays = 0;

            while (stack.size() > 0 && plants[stack.peek()] >= plants[i]){
                maxDays = Math.max(maxDays, days[stack.pop()]);
            }
            if (stack.size() > 0)
            {
                days[i] = maxDays + 1;
            }
            stack.push(i);
        }
        int max = Integer.MIN_VALUE;
        for (int day : days) {
            if (day > max) {
                max = day;
            }
        }
        System.out.println(max);
    }
}