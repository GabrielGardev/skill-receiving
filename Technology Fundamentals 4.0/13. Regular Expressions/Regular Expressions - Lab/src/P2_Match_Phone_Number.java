import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P2_Match_Phone_Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("\\+359([- ])2\\1(\\d{3})\\1(\\d{4})\\b");
        String phones = scanner.nextLine();

        Matcher matcher = pattern.matcher(phones);

        List<String> validPhones = new ArrayList<>();
        while (matcher.find()){
            validPhones.add(matcher.group());
        }

        System.out.println(String.join(", ", validPhones));
    }
}
