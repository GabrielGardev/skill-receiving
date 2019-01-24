import java.util.Arrays;
import java.util.Scanner;

public class P3_Zig_Zag_Arrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] firstArr = new int[n];
        int[] secondArr = new int[n];


        for (int i = 0; i < n; i++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (i % 2 == 0){
                firstArr[i] = numbers[0];
                secondArr[i] = numbers[1];
            }else {
                firstArr[i] = numbers[1];
                secondArr[i] = numbers[0];
            }
        }
        for (var num : firstArr){
            System.out.print(num + " ");
        }
        System.out.println();
        for (var num : secondArr){
            System.out.print(num + " ");
        }
    }
}
