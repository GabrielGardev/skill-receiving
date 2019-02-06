import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P01_Sort_Even_Numbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> nums = Arrays.stream(reader.readLine().split(", "))
                .map(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .map(String::valueOf)
                .collect(Collectors.toList());

        System.out.println(String.join(", ", nums));

        nums = nums.stream().map(Integer::parseInt)
                .sorted(Integer::compare)
                .map(String::valueOf)
                .collect(Collectors.toList());

        System.out.println(String.join(", ", nums));
    }
}
