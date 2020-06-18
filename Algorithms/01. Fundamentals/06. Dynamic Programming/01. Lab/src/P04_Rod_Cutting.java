import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P04_Rod_Cutting {
    public static int[] bestPrices;
    public static int[] prevIndex;
    public static int[] prices;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        prices = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int length = Integer.parseInt(reader.readLine());
        bestPrices = new int[length + 1];
        prevIndex = new int[length + 1];

        int maxProfit = cutRod(length);

        System.out.println(maxProfit);

        reconstructSolution(length);

    }

    private static int cutRod(int length) {
        if (length == 0) {
            return 0;
        }

        if (bestPrices[length] != 0) {
            return bestPrices[length];
        }

        int currentBestPrice = bestPrices[length];

        for (int i = 1; i <= length; i++) {
            currentBestPrice = Math.max(currentBestPrice, prices[i] + cutRod(length - i));
            if (currentBestPrice > bestPrices[length]) {
                bestPrices[length] = currentBestPrice;
                prevIndex[length] = i;
            }
        }

        return bestPrices[length];
    }

    private static void reconstructSolution(int length) {
        while (length - prevIndex[length] != 0) {
            System.out.print(prevIndex[length] + " ");
            length = length - prevIndex[length];
        }
        System.out.println(prevIndex[length]);
    }
}
