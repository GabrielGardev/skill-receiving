import java.util.Scanner;

public class P1_Smallest_of_Three_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());

        printSmallestInteger(firstNum, secondNum, thirdNum);
    }

    private static void printSmallestInteger(int firstNum, int secondNum, int thirdNum) {
        int min = Integer.MAX_VALUE;

        if (firstNum < min){
            min = firstNum;
        }
        if (secondNum < min){
            min = secondNum;
        }
        if (thirdNum < min){
            min = thirdNum;
        }
        System.out.println(min);
    }
}
