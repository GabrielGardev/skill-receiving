import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P02_The_Mad_Gardener {
    public static class Sequence {
        int size;
        int prev;
        int sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] plants = new int[input.length + 1];
        for (int i = 1; i < plants.length; i++) {
            plants[i] = input[i - 1];
        }

        Sequence[] firstLis = getLIS(plants);
        int[] reversed = new int[plants.length];

        for (int i = 1; i < input.length; i++) {
            reversed[i] = plants[(plants.length - 1) - i + 1];
        }
        Sequence[] secondLis = getLIS(reversed);

        int maxSize = 0;
        int maxSum = 0;
        int peek = 0;
        int end = plants.length - 1;

        for (int i = 1; i < plants.length; i++) {
            int size = firstLis[i].size + secondLis[end - i + 1].size;
            if (size >= maxSize ){
                maxSize = size;
                maxSum = firstLis[i].sum + secondLis[end - i + 1].sum - plants[i];
                peek = i;
            }
        }

        int[] result = new int[plants.length];

        int element = firstLis[peek].size;
        int index = peek;
        int nextElement = 0;

        while (index != 0){
            nextElement++;
            result[element--] = plants[index];
            index = firstLis[index].prev;
        }

        index = secondLis[plants.length - peek].prev;

        while (index != 0){
            result[++nextElement] = reversed[index];
            index = secondLis[index].prev;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < maxSize; i++) {
            sb.append(result[i]).append(" ");
        }
        sb.append(System.lineSeparator());
        sb.append(String.format("%.2f", maxSum / (maxSize - 1 * 1.00))).append(System.lineSeparator());
        sb.append(maxSize - 1);

        System.out.println(sb);
    }

    private static Sequence[] getLIS(int[] plants) {
        Sequence[] lis = new Sequence[plants.length];
        lis[0] = new Sequence();

        for (int i = 1; i <= plants.length - 1; i++) {
            lis[i] = new Sequence();
            for (int j = 0; j < i; j++) {
                if (plants[j] <= plants[i]){
                    if (lis[j].size + 1 > lis[i].size
                            || ((lis[j].size + 1 == lis[i].size) && lis[j].sum + plants[i] > lis[i].sum)){
                        lis[i].sum = lis[j].sum + plants[i];
                        lis[i].size = lis[i].size + 1;
                        lis[i].prev = j;
                    }
                }
            }
        }
        return lis;
    }
}