import java.util.Scanner;

public class P1_Binary_Digits_Count {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char b = scanner.nextLine().charAt(0);

        String binary = Integer.toBinaryString(n);


        int counter = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == b){
                counter++;
            }
        }
        System.out.println(counter);
    }
}
