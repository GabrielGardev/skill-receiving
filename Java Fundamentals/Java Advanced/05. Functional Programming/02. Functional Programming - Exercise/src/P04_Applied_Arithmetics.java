import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class P04_Applied_Arithmetics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Function<int[], int[]> addOne = x -> Arrays.stream(x).map(e -> e += 1).toArray();
        UnaryOperator<int[]> sub = arr -> Arrays.stream(arr).map(e -> e -= 1).toArray();
        UnaryOperator<int[]> mul = arr -> Arrays.stream(arr).map(e -> e *= 2).toArray();
        Consumer<int[]> print = x -> Arrays.stream(x).forEach(e -> System.out.print(e + " "));

        int[] nums = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        while (true){
            String cmd = reader.readLine();
            if (cmd.equals("end")){
                break;
            }
            switch (cmd){
                case "add":
                    nums = addOne.apply(nums);
                    break;
                case "multiply":
                    nums = mul.apply(nums);
                    break;
                case "subtract":
                    nums = sub.apply(nums);
                    break;
                case "print":
                    print.accept(nums);
                    System.out.println();
                    break;
            }
        }
    }
}
