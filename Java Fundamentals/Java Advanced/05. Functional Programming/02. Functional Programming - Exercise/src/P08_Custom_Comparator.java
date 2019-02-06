import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class P08_Custom_Comparator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Comparator<Integer> comparator = (a, b) -> {
           if (a % 2 == 0 && b % 2 != 0){
               return -1;
           }else if (b % 2 == 0 && a % 2 != 0){
               return 1;
           }
           return a.compareTo(b);
        };

        Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted(comparator)
                .forEach(x -> System.out.print(x + " "));

    }
}
