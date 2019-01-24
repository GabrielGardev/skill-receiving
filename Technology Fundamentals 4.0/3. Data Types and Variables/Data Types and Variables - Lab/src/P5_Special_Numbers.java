import java.util.Scanner;

public class P5_Special_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int digits = i;

            while (digits > 0) {
                sum += digits % 10;
                digits = digits / 10;
            }

            boolean isSpecial = sum == 5 || sum == 7 || sum == 11;
            String special = isSpecial + "";
            special = (special.charAt(0) + "").toUpperCase() + special.substring(1);
            System.out.printf("%d -> %s\n", i, special);
        }
    }
}
