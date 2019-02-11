import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P2_Gauss_Trick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        if (numbers.size() == 1){
            String printer = jointElementsByDelimeter(numbers, " ");
            System.out.println(printer);
            return;
        }

        int first = 0;
        int last = numbers.size() - 1;

        List<Double> result = new ArrayList<>();
        for (int i = 0; i < numbers.size() / 2; i++) {
            result.add(numbers.get(first + i) + numbers.get(last - i));

            if (numbers.size() % 2 != 0 && i == (numbers.size() / 2) - 1){
                result.add(numbers.get(numbers.size() / 2));
            }
        }
        String printer = jointElementsByDelimeter(result, " ");
        System.out.println(printer);
    }
    static String jointElementsByDelimeter(List<Double> numbers, String s) {
        String output = "";
        for (Double number : numbers) {
            output += (new DecimalFormat("0.#").format(number) + s);
        }
        return output;
    }
}
