import java.util.Scanner;

public class P10_Top_Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        if (num < 17){
            return;
        }

        for (int i = 17; i <= num; i++) {
            if (IsItSumIsDivisibleBy8(i) && IsItHaveOneOddNum(i)){
                System.out.println(i);
            }

        }
    }

    private static boolean IsItHaveOneOddNum(int i) {
        int currentNum = 0;
        while (i > 0){
            currentNum = i % 10;
            if (currentNum % 2 != 0){
                return true;
            }
            i /= 10;
        }
        return false;
    }

    private static boolean IsItSumIsDivisibleBy8(int i) {
        int sum = 0;
        while (i > 0){
            sum += i % 10;
            i /= 10;
        }
        if (sum % 8 == 0){
            return true;
        }
        return false;
    }
}
