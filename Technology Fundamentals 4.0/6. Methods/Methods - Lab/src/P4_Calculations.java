import java.util.Scanner;

public class P4_Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        switch (command) {
            case "add":
                add(firstNum, secondNum);
                break;
            case "divide":
                divide(firstNum, secondNum);
                break;
            case "subtract":
                subtract(firstNum, secondNum);
                break;
            case "multiply":
                multiply(firstNum, secondNum);
                break;
        }
    }
    private static void add(int a, int b){
        System.out.println(a + b);
    }
    private static void divide(int a, int b){
        System.out.println(a / b);

    }
    private static void subtract(int a, int b){
        System.out.println(a - b);

    }
    private static void multiply(int a, int b){
        System.out.println(a * b);

    }
}
