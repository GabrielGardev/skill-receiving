import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P7_HTML_parser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        String titleOfSite = "";

        Pattern title = Pattern.compile("<title>(?<title>.+)<\\/title>");
        Matcher matcher = title.matcher(line);
        if (matcher.find()){
            titleOfSite = matcher.group("title");
        }

        String [] splited = line.split("<body>");
        String [] secondSplit = splited[1].split("<(?:\"[^\"]*\"['\"]*|'[^']*'['\"]*|[^'\">])+>");

        StringBuilder sb = new StringBuilder();

        for (String s : secondSplit) {
            if (s.equals("") || s.equals("\\\\n")){
                continue;
            }

            for (int i = 0; i < s.length(); i++) {
                char currentChar = s.charAt(i);

                if (currentChar == '\\' && s.charAt(i + 1) == 'n'){
                    if (i != 0) {
                        sb.append(" ");
                    }
                    i++;
                    continue;
                }

                if (!Character.isDigit(currentChar)) {
                    sb.append(currentChar);
                }
            }
            sb.append(" ");
        }
        String [] finale = sb.toString().trim().split("\\s+");
        System.out.println(String.format("Title: %s",titleOfSite));
        System.out.print("Content: ");
        System.out.println(String.join(" ", finale));
    }
}
