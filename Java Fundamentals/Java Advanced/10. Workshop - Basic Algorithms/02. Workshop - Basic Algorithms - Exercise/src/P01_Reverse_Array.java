import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P01_Reverse_Array {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        printReversedArray(arr, arr.length - 1);
    }

    private static void printReversedArray(int[] arr, int index) {

        if (index < 0){
            return;
        }


        System.out.print(arr[index] + " ");
        printReversedArray(arr, index - 1);
    }
}
