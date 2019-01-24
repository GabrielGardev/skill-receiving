import java.util.Scanner;

public class P1_Integer_Operations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        long secondNum = Long.parseLong(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());
        int fourtNum = Integer.parseInt(scanner.nextLine());

        secondNum += firstNum;
        secondNum /= thirdNum;
        secondNum *= fourtNum;

        System.out.println(secondNum);
    }
}
