import java.util.Scanner;

public class P3_Pth_Bit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        int shifted = n >> b;
        int bitAtPositionZero = shifted & 1;

        System.out.println(bitAtPositionZero);
    }
}
