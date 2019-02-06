import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;

public class P06_Predicate_for_Names {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Predicate<String> checkLength = e -> e.length() <= n;

        Arrays.stream(reader.readLine().split("\\s+"))
                .filter(checkLength)
                .forEach(System.out::println);
    }
}
