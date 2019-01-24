import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

public class P03_Periodic_Table {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        var elements = new TreeSet<String>();

        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split("\\s+");

            elements.addAll(Arrays.asList(line));
        }
        for (String element : elements) {
            System.out.print(element + " ");
        }
    }
}
