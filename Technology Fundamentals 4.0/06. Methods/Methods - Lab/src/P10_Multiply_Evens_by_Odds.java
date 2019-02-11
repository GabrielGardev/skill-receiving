import java.util.Scanner;

public class P10_Multiply_Evens_by_Odds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Math.abs(Integer.parseInt(scanner.nextLine()));

        System.out.println(GetSum(num));
    }

    private static int GetSum(int num) {
        int evenSum = GetEvenSum(num);
        int oddSum = GetOddSum(num);

        return evenSum * oddSum;
    }

    private static int GetOddSum(int num) {
        int oddSum = 0;
        while (num > 0){
            int currentNum;
            currentNum = num % 10;
            if (currentNum % 2 != 0){
                oddSum += currentNum;
            }
            num /= 10;
        }
        return oddSum;
    }

    private static int GetEvenSum(int num) {
        int evenSum = 0;
        while (num > 0){
            int currentNum;
            currentNum = num % 10;
            if (currentNum % 2 == 0){
                evenSum += currentNum;
            }
            num /= 10;
        }
        return evenSum;
    }
}
