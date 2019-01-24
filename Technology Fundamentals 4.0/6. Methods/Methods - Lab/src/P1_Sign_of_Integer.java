import java.util.Scanner;

public class P1_Sign_of_Integer {
    static void printNum(int num){
        if (num > 0){
            System.out.printf("The number %d is positive.", num);
        }else if (num < 0){
            System.out.printf("The number %d is negative.", num);
        }else {
            System.out.printf("The number %d is zero.", num);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        printNum(n);
    }
}
