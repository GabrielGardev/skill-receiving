import java.util.*;

public class P2_Word_Synonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> words = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            words.putIfAbsent(word, new ArrayList<>());
            words.get(word).add(synonym);
        }
        for (var entry : words.entrySet()) {
            System.out.printf("%s - ", entry.getKey());
            System.out.println(String.join(", ", entry.getValue()));
        }
    }
}
