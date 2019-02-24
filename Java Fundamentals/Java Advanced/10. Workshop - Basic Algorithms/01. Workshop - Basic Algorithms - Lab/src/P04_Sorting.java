import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class P04_Sorting {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] list = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        bubble(list);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }

    private static void bubble(int[] list) {
        for (int i = 0; i < list.length; i++) {
            boolean sorted = true;
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j] > list[j + 1]){
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    sorted = false;
                }
            }
            if (sorted){
                break;
            }
        }
    }
}
