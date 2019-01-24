import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class P04_Count_Symbols {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<Character, Integer> chars = new TreeMap<>();

        String line = reader.readLine();

        for (int i = 0; i < line.length(); i++) {
            char currentChar = line.charAt(i);

            chars.putIfAbsent(currentChar, 0);
            chars.put(currentChar, chars.get(currentChar) + 1);
        }

        for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
            System.out.println(String.format("%c: %d time/s", entry.getKey(), entry.getValue()));
        }
    }
}
