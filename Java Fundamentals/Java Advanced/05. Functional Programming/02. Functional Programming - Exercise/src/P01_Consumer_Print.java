import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class P01_Consumer_Print {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Consumer<String> printer = System.out::println;
        Arrays.stream(reader.readLine().split(" "))
                .forEach(printer);
    }
}
