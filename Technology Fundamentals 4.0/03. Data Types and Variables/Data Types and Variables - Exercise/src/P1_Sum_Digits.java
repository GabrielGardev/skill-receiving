import java.util.Scanner;

public class P1_Sum_Digits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        while (number > 0){
            int num;

            num = number % 10;
            sum += num;
            number /= 10;
        }
        System.out.println(sum);
    }
}
