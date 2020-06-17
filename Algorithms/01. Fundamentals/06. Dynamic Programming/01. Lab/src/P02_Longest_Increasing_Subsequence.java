import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P02_Longest_Increasing_Subsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] sequence = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] length = new int[sequence.length];
        int[] prev = new int[sequence.length];

        Arrays.fill(prev, -1);

        int maxIndex = -1, maxLength = 0;

        for (int i = 0; i < sequence.length; i++) {
            int currentNum = sequence[i];
            int bestLength = 1;
            int bestIndex = -1;

            for (int j = i - 1; j >= 0; j--) {
                int prevNum = sequence[j];
                int prevLength = length[j];
                if (prevNum < currentNum && prevLength + 1 >= bestLength){
                    bestLength = prevLength + 1;
                    bestIndex = j;
                }
            }
            prev[i] = bestIndex;
            length[i] = bestLength;

            if (bestLength > maxLength){
                maxLength = bestLength;
                maxIndex = i;
            }
        }

        printResult(sequence, prev, maxIndex);
    }

    private static void printResult(int[] sequence, int[] prev, int maxIndex) {
        List<Integer> result = new ArrayList<>();

        while (maxIndex != -1){
            result.add(sequence[maxIndex]);
            maxIndex = prev[maxIndex];
        }
        Collections.reverse(result);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
