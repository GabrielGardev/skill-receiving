import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class P02_Sum_Numbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] line = reader.readLine().split(", ");

        Function<String, Integer> parser = Integer::parseInt;

        int sum = 0;

        for (String s : line) {
            sum += parser.apply(s);
        }
        System.out.println("Count = " + line.length);
        System.out.println("Sum = " + sum);
    }
}
