import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P03_Count_Uppercase_Words {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] line = reader.readLine().split(" ");

        Predicate<String> isItUpper = s -> s.charAt(0) == s.toUpperCase().charAt(0);

        List<String> result = Arrays.stream(line).filter(isItUpper).collect(Collectors.toList());

        System.out.println(result.size());
        for (String s : result) {
            System.out.println(s);
        }

    }
}
