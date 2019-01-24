import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P5_Largest_3_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .sorted((a , b) -> b.compareTo(a))
                .collect(Collectors.toList());

        int count = numbers.size() >= 3 ? 3 : numbers.size();

            for (int i = 0; i < count; i++) {
                System.out.print(numbers.get(i) + " ");
            }
    }
}
