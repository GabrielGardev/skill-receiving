import java.util.Scanner;

public class P3_Passed_or_Failed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double grade = Double.parseDouble(scanner.nextLine());

        if (grade >= 3) {
            System.out.println("Passed!");
        }else {
            System.out.println("Failed!");
        }
    }
}
