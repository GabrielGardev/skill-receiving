import java.awt.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P2_Deciphering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String sentence = scanner.nextLine();
        String[] letters = scanner.nextLine().split(" ");

        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("[^b-z{}|#]");
        Matcher matcher = pattern.matcher(sentence);

        if (matcher.find()){
            System.out.println("This is not the book you are looking for.");
            return;
        }

        for (int i = 0; i < sentence.length(); i++) {
            char ch = (char)(sentence.charAt(i) - 3);

            sb.append(ch);
        }

        String result = sb.toString().replaceAll(letters[0], letters[1]);
        System.out.println(result);
    }
}
