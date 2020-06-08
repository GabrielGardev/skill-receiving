import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P01_Binary_Search {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int num = Integer.parseInt(reader.readLine());

        System.out.println(getIndex(arr, num));
    }

    public static int getIndex(int[] arr, int num){
        int start = 0;
        int end = arr.length - 1;

        while (end >= start){
            int mid = (start + end) / 2;

            if (num < arr[mid]){
                end = mid - 1;
            }else if (num > arr[mid]){
                start = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
