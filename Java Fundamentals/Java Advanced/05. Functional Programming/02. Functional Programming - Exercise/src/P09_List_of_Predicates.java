import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P09_List_of_Predicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        HashSet<Integer> divisibleNumbers = Arrays.stream(reader.readLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(HashSet::new));

        Predicate<Integer> isItDivisible = x -> {
            for (Integer number : divisibleNumbers) {
                if (x % number != 0) {
                    return false;
                }
            }
            return true;
        };

        IntStream.rangeClosed(1, n)
                .filter(isItDivisible::test)
                .boxed()
                .forEach(x -> System.out.print(x + " "));
    }
}
