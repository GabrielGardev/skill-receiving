import java.util.Scanner;

public class P5_Add_and_Subtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());

        int sum = firstNum + secondNum;
        System.out.println(Substract(sum, thirdNum));
    }

    private static int Substract(int sum, int thirdNum) {

        return sum - thirdNum;
    }
}
