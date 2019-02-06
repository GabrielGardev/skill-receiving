import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Arrays;
        import java.util.HashSet;
        import java.util.function.Function;

public class P03_Custom_Min_Function {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Function<int[], Integer> MinElement = x -> Arrays.stream(x).min().getAsInt();

        int[] nums = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();


        System.out.println(MinElement.apply(nums));
    }
}
