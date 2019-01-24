import java.util.Scanner;

public class P4_Caesar_cipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            char newChar = (char)(line.charAt(i) + 3);

            sb.append(newChar);

        }
        System.out.println(sb.toString());
    }
}
