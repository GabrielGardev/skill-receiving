import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P6_Rage_Quit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine().toUpperCase();

        Pattern pattern = Pattern.compile("(?<text>[^\\d]{1,20})(?<count>\\d+)");
        Matcher matcher = pattern.matcher(line);

        StringBuilder sb = new StringBuilder();

        while (matcher.find()) {
                int count = Integer.parseInt(matcher.group("count"));
                String massage = matcher.group("text");

                for (int j = 0; j < count; j++) {
                    sb.append(massage);
                }
        }
        List<Character> chars = sb.toString().chars().mapToObj(c -> (char) c).distinct().collect(Collectors.toList());
        System.out.println(String.format("Unique symbols used: %d", chars.size()));
        System.out.println(sb.toString());
    }
}
