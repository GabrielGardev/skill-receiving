import java.util.Scanner;

public class P11_Math_operations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        int secondNum = Integer.parseInt(scanner.nextLine());

        System.out.println(Math.round(CalculateNumbers(firstNum, operator, secondNum)));
    }

    private static double CalculateNumbers(int firstNum, String operator, int secondNum) {
        double result = 0;
        switch (operator) {
            case "-":
                result = firstNum - secondNum;
                break;
            case "+":
                result = firstNum + secondNum;
                break;
            case "*":
                result = firstNum * secondNum;
                break;
            case "/":
                result = firstNum / secondNum;
                break;
        }
        return result;
    }
}
