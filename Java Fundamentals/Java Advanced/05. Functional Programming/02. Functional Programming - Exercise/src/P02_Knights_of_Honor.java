import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class P02_Knights_of_Honor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Consumer<String> printer = str -> System.out.println("Sir " + str);
        Arrays.stream(reader.readLine().split(" "))
                .forEach(printer);
    }
}
