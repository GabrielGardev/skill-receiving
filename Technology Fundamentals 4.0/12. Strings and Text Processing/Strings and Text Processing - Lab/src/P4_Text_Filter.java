import java.util.Scanner;

public class P4_Text_Filter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] badWords = scanner.nextLine().split(", ");

        String text = scanner.nextLine();

        for (String badWord : badWords) {
            String replacement = repeatStr("*", badWord.length());
            text = text.replace(badWord, replacement);
        }
        System.out.println(text);
    }
    static String repeatStr (String text, int count) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < count; i++) {
            result.append(text);
        }
        return result.toString();
    }
}
