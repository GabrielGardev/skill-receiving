import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P1_Extract_Emails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("(^|(?<=\\s))([A-Za-z0-9]+)([\\._-]?)([A-Za-z0-9]*)@([A-Za-z]+)([-\\.]*)([A-Za-z]*)([-\\.]*)([A-Za-z]*)\\.([a-z]+)");

        String input = scanner.nextLine();

        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
