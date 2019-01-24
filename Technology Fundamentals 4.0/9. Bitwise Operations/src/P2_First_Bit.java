import java.util.Scanner;

public class P2_First_Bit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int shifted = n >> 1;
        int bitAtPositionZero = shifted & 1;

        System.out.println(bitAtPositionZero);
    }
}
