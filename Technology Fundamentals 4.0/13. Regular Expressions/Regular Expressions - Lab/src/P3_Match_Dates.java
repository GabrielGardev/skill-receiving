import java.util.Scanner;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class P3_Match_Dates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("(?<day>\\d{2})(?<separator>[-.\\/])(?<month>[A-Z][a-z]{2})\\k<separator>(?<year>\\d{4})");

        String input = scanner.nextLine();
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){
            System.out.println(String.format("Day: %s, Month: %s, Year: %s", matcher.group("day"),
                    matcher.group("month"), matcher.group("year")));
        }
    }
}
