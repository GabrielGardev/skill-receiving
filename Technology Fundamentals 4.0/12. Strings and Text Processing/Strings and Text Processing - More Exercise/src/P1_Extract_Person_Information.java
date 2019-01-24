import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P1_Extract_Person_Information {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String namePattern = "@(.+)\\|";
            String agePattern = "#(\\d+)\\*";

            Pattern patternName = Pattern.compile(namePattern);
            Pattern patternAge = Pattern.compile(agePattern);

            Matcher matcherName = patternName.matcher(line);
            Matcher matcherAge = patternAge.matcher(line);

            if (matcherName.find()){
                if (matcherAge.find()){
                    System.out.println(String.format("%s is %s years old.",matcherName.group(1), matcherAge.group(1)));
                }
            }
        }
    }
}
