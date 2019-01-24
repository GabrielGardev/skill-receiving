import java.util.Scanner;

public class P1_Repeat_strings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String words[] = scanner.nextLine().split(" ");

        StringBuilder result = new StringBuilder();

        for (String word : words) {
            int length = word.length();
            for (int i = 0; i < length; i++) {
                result.append(word);
            }
        }
        System.out.println(result);
    }
}
