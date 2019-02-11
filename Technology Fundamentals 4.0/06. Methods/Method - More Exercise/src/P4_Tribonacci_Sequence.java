import java.util.Scanner;

public class P4_Tribonacci_Sequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int[] numbers = new int[num];

        for (int i = 0; i < num; i++) {
            numbers[i] = GetTribonacci(numbers, i);
        }

        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }

    private static int GetTribonacci(int[] numbers, int i) {
        if (i == 0) return 1;
        if (i == 1) return 1;
        if (i == 2) return 2;

        int a = numbers[i - 1];
        int b = numbers[i - 2];
        int c = numbers[i - 3];

        return a + b +c;
    }


}
