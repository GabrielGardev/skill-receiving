import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P01_Recursive_Array_Sum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

       List<Integer> arr = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
               .collect(Collectors.toCollection(ArrayList::new));

       int sum = arraySum(arr, 0);

        System.out.println(sum);
    }

    private static int arraySum(List<Integer> arr, int index) {
        if (index == arr.size() - 1){
            return arr.get(index);
        }

        return arr.get(index) + arraySum(arr, index + 1);
    }
}
