import java.util.Arrays;
import java.util.Scanner;

public class P5_Top_Integers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String tops = "";

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]){
                    max = arr[i];
                    if (j == arr.length - 1){
                        tops += max + " ";
                    }
                }else {
                    break;
                }
            }
        }
        System.out.println(tops + arr[arr.length - 1]);
    }
}
