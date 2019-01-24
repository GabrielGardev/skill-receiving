import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P5_Star_Enigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<String> decrypted = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            int count = 0;
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < line.length(); j++) {
                char currentChar = line.charAt(j);

                switch (currentChar){
                    case 's':
                    case 'S':
                    case 't':
                    case 'T':
                    case 'a':
                    case 'A':
                    case 'r':
                    case 'R':
                        count++;
                        break;
                }
            }
            for (int j = 0; j < line.length(); j++) {
                char currentChar = (char)(line.charAt(j) - count);

                sb.append(currentChar);
            }
            decrypted.add(sb.toString());
        }
        List<String> attacked = new ArrayList<>();
        List<String> destroyed = new ArrayList<>();

        for (String s : decrypted) {
            Pattern pattern = Pattern
                    .compile("([^@:!\\->]*)@(?<planet>[A-Za-z]+)([^@:!\\->]*):(?<population>\\d+)([^@:!\\->]*)!(?<type>[AD])!([^@:!\\->]*)->(?<soldiers>\\d+)([^@:!\\->]*)");
            Matcher matcher = pattern.matcher(s);

            if (matcher.find()){
                String type = matcher.group("type");
                String name = matcher.group("planet");

                if (type.equals("A")){
                    attacked.add(name);
                }else {
                    destroyed.add(name);
                }
            }
        }
        Collections.sort(attacked);
        Collections.sort(destroyed);

        System.out.println(String.format("Attacked planets: %d",attacked.size()));
        for (String s1 : attacked) {
            System.out.println(String.format("-> %s",s1));
        }
        System.out.println(String.format("Destroyed planets: %d",destroyed.size()));
        for (String s1 : destroyed) {
            System.out.println(String.format("-> %s",s1));
        }
    }
}
