import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P2_Activation_Keys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] keys = scanner.nextLine().split("&");
        List<String> newKeys = new ArrayList<>();

        for (String key : keys) {
            Pattern pattern = Pattern.compile("^[A-Za-z0-9]+$");
            Matcher matcher = pattern.matcher(key);

            StringBuilder sb = new StringBuilder();
            if (matcher.find()) {
                if (key.length() == 16) {
                    for (int i = 0; i < key.length(); i++) {
                        for (int j = i; j < i + 4; j++) {
                            char currentChar = key.charAt(j);
                            if (Character.isLetter(currentChar)){
                                sb.append(Character.toUpperCase(currentChar));
                            }else {
                                int num = 9 - Integer.parseInt(currentChar + "");
                                sb.append(num);
                            }
                        }
                        i += 3;
                        if (i < 15) {
                            sb.append("-");
                        }
                    }
                    newKeys.add(sb.toString());
                }
                if (key.length() == 25) {
                    for (int i = 0; i < key.length(); i++) {
                        for (int j = i; j < i + 5; j++) {
                            char currentChar = key.charAt(j);
                            if (Character.isLetter(currentChar)){
                                sb.append(Character.toUpperCase(currentChar));
                            }else {
                                int num = 9 - Integer.parseInt(currentChar + "");
                                sb.append(num);
                            }
                        }
                        i += 4;
                        if (i < 24) {
                            sb.append("-");
                        }
                    }
                    newKeys.add(sb.toString());
                }
            }
        }
        System.out.println(String.join(", ", newKeys));
    }
}
