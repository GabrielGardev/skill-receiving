import java.util.*;

public class P1_Count_Chars_in_a_String {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        Map<Character, Integer> result = new LinkedHashMap<>();

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' '){
                continue;
            }
            if (result.containsKey(text.charAt(i)) == false){
                result.put(text.charAt(i), 0);
            }
            result.put(text.charAt(i), result.get(text.charAt(i)) + 1);
        }
        result.entrySet()
                .stream()
                .forEach(x -> System.out.println(x.getKey() + " -> " + x.getValue()));

    }
}
