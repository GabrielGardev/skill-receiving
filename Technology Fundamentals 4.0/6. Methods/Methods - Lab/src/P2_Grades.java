import java.util.Scanner;

public class P2_Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num = Double.parseDouble(scanner.nextLine());
        printTheSumInWords(num);
    }

    static void printTheSumInWords(double num) {
        if (num >= 2.00 && num < 2.99){
            System.out.println("Fail");
        }else if (num <= 3.49){
            System.out.println("Poor");
        }else if (num <= 4.49){
            System.out.println("Good");
        }else if (num <= 5.49){
            System.out.println("Very good");
        }else if (num <= 6){
            System.out.println("Excellent");
        }
    }
}
