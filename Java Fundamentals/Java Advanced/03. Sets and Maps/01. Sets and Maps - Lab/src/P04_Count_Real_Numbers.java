import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class P04_Count_Real_Numbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double[] values = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> valuesWithOccurrence = new LinkedHashMap<>();

        for (double value : values) {
            valuesWithOccurrence.putIfAbsent(value , 0);
            valuesWithOccurrence.put(value, valuesWithOccurrence.get(value) + 1);
        }

        for (Double key : valuesWithOccurrence.keySet()) {
            System.out.println(String.format("%.1f -> %d", key, valuesWithOccurrence.get(key)));
        }
    }
}
