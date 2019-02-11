import java.util.Scanner;

public class P6_Tri_bit_Switch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        int mask = 7 << b;
        int result = n ^ mask;

        System.out.println(result);
    }
}
