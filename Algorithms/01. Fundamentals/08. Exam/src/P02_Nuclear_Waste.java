import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P02_Nuclear_Waste {
    public static int flasks;
    public static int[] price;
    public static int[] minPrice;
    public static int[] previousFlaskCount;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] costs = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        flasks = Integer.parseInt(reader.readLine());

        price = new int[costs.length + 1];
        price[0] = 0;
        minPrice = new int[flasks + 1];

        System.arraycopy(costs, 0, price, 1, costs.length);

        minPrice();
        previousFlaskCount = new int[flasks + 1];

        pricer();
        print();
    }

    private static void minPrice() {
        for (int i = 0; i <= flasks; i++) {
            if (i >= price.length) {
                minPrice[i] = minPrice[i - 1] + minPrice[1];
            } else {
                minPrice[i] = price[i];
            }
        }
    }

    private static void print() {
        sb.append("Cost: ").append(minPrice[flasks])
                .append(System.lineSeparator());

        int size = flasks;
        while (previousFlaskCount[size] > 0) {
            sb.append(previousFlaskCount[size]).append(" => ").append(minPrice[previousFlaskCount[size]])
                    .append(System.lineSeparator());
            size = size - previousFlaskCount[size];
        }
        sb.append(size).append(" => ").append(minPrice[size]);
        System.out.println(sb);
    }

    private static void pricer() {
        for (int i = 1; i < flasks + 1; i++) {
            for (int j = 1; j <= i; j++) {
                int currentMinPrice;

                if (j >= price.length) {
                    currentMinPrice = minPrice[j] + minPrice[i - j];
                } else {
                    currentMinPrice = price[j] + minPrice[i - j];
                }
                if (currentMinPrice < minPrice[i]) {
                    minPrice[i] = currentMinPrice;
                    previousFlaskCount[i] = j;
                }
            }
        }
    }
}