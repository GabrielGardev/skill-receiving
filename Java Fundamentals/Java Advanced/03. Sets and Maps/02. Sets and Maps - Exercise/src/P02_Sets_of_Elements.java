import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class P02_Sets_of_Elements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        var firstSet = new LinkedHashSet<String>();
        var secondSet = new LinkedHashSet<String>();


        int [] n = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < n[0]; i++) {
            String num = reader.readLine();
            firstSet.add(num);
        }
        for (int i = 0; i < n[1]; i++) {
            String num = reader.readLine();
            secondSet.add(num);
        }

        firstSet.retainAll(secondSet);

        System.out.println(String.join(" ", firstSet));
    }
}
