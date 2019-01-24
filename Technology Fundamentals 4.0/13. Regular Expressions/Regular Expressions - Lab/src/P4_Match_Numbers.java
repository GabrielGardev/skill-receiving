import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P4_Match_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("(^|(?<=\\s))-?\\d+(\\.\\d+)?($|(?=\\s))");
        String input = scanner.nextLine();
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){
            System.out.print(matcher.group() + " ");
        }
    }
}
