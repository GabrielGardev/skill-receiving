import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P7_Remove_Negatives_and_Reverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());

        numbers.removeIf(x -> x < 0);
        Collections.reverse(numbers);

        if (numbers.isEmpty()){
            System.out.println("empty");
        }else {
            numbers.forEach(x -> System.out.print(x + " "));
        }
    }
}
