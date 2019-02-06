import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class P04_Add_VAT {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        UnaryOperator<Double> addVat = num -> num * 1.2;

        System.out.println("Prices with VAT:");

        Arrays.stream(reader.readLine().split(", "))
                .map(Double::parseDouble)
                .map(addVat)
                .forEach(x -> System.out.printf("%.2f%n", x));
    }
}
