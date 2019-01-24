import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P3_Treasure_Finder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] keys = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<String> decode = new ArrayList<>();

        while (true){
            String line = scanner.nextLine();
            if (line.equals("find")){
                break;
            }

            StringBuilder sb = new StringBuilder();
            int j = 0;
            if (line.length() > keys.length){
                for (int i = 0; i < line.length(); i++) {
                    char currentChar = line.charAt(i);

                    currentChar -= keys[j];
                    j++;
                    if (j == keys.length){
                        j = 0;
                    }
                    sb.append(currentChar);
                }
            }else {
                Collections.reverse(Arrays.asList(keys));
                for (int i = 0; i < line.length(); i++) {
                    char currentChar = line.charAt(i);

                    currentChar -= keys[j];
                    j++;

                    sb.append(currentChar);
                }
            }
            decode.add(sb.toString());
        }
        for (String s : decode) {
            Pattern type = Pattern.compile("&(.+)&");
            Pattern coordinates = Pattern.compile("<(.+)>");

            Matcher matcherType = type.matcher(s);
            Matcher matcherCoordinates = coordinates.matcher(s);

            if (matcherType.find()){
                if (matcherCoordinates.find()){
                    System.out.println(String.format("Found %s at %s", matcherType.group(1), matcherCoordinates.group(1)));
                }
            }
        }
    }
}
