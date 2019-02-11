import java.util.Scanner;

public class P9_Refactor_Special_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int total = 0;
        int sum = 0;
        boolean isSpecial = false;
        for (int i = 1; i <= num; i++) {
            sum = i;
            while (i > 0) {
                total += i % 10;
                i = i / 10;
            }
            isSpecial = (total == 5) || (total == 7) || (total == 11);
            String special = isSpecial + "";
            special = (special.charAt(0) + "").toUpperCase() + special.substring(1);
            System.out.printf("%d -> %s%n", sum, special);
            total = 0;
            i = sum;
        }
    }
}
