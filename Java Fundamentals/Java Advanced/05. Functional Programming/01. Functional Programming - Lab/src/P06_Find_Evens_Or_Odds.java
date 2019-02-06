import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class P06_Find_Evens_Or_Odds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String type = reader.readLine();

        Predicate<Integer> evens = num -> num % 2 == 0;
        Predicate<Integer> odds = num -> num % 2 != 0;

        IntStream.rangeClosed(input[0], input[1])
                .boxed()
                .filter(e -> type.equals("even") ?
                        evens.test(e) :
                        odds.test(e))
                .forEach(x -> System.out.print(x + " "));

    }
}
