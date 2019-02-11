import java.util.Scanner;

public class P1_Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] train = new int[n];

        for (int i = 0; i < n; i++) {
            train[i] = Integer.parseInt(scanner.nextLine());
        }
        int sum = 0;
        for (var num : train){
            sum += num;
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println(sum);
    }
}
