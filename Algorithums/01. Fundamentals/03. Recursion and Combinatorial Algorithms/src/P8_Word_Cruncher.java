import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class P8_Word_Cruncher {
    public static List<String> words;
    public static String target;
    public static Map<Integer, List<String>> table = new HashMap<>();
    public static Map<String, Integer> occurrences = new HashMap<>();
    public static Set<String> result = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        words = Arrays.stream(reader.readLine().split(", ")).collect(Collectors.toList());
        target = reader.readLine();

        clearUnusedWords();

        for (String word : words) {
            occurrences.putIfAbsent(word, 1);

            int index = target.indexOf(word);
            while (index != -1) {
                table.putIfAbsent(index, new ArrayList<>());
                table.get(index).add(word);
                index = target.indexOf(word, index + 1);
            }
        }
        words.clear();
        permute(0);

        for (String s : result) {
            System.out.println(s);
        }
    }

    public static void permute(int index) {
        if (index == target.length()) {
            addInSet();
        } else if (table.containsKey(index)) {
            List<String> strings = table.get(index);
            for (String str : strings) {
                if (occurrences.get(str) > 0) {
                    occurrences.put(str, occurrences.get(str) - 1);
                    words.add(str);
                    permute(index + str.length());
                    words.remove(words.size() - 1);
                    occurrences.put(str, occurrences.get(str) + 1);
                }
            }
        }
    }

    private static void clearUnusedWords() {
        words.removeIf(word -> !target.contains(word));
    }

    private static void addInSet() {
        String joined = String.join("", words);
        if (joined.contains(target)) {
            result.add(String.join(" ", words));
        }
    }
}
