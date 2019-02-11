import java.util.*;

public class P1_Dictionary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> dictionary = new TreeMap<>();
        String[] wordsAndDefinition = scanner.nextLine().split(" \\| ");

        for (String s : wordsAndDefinition) {
          //  String [] temp = s.split(": ");
            String word = s.split(": ")[0];
            String definition = s.split(": ")[1];

            dictionary.putIfAbsent(word, new ArrayList<>());
            dictionary.get(word).add(definition);
        }
        String[] words = scanner.nextLine().split(" \\| ");

        for (String word : words) {
            if (dictionary.containsKey(word)){
                dictionary.get(word).sort((a, b) -> Integer.compare(b.length(), a.length()));
                System.out.println(word);
                dictionary.get(word).forEach(x -> {
                    System.out.println(String.format(" -%s", x));
                });
            }
        }
        String cmd = scanner.nextLine();

        if (cmd.equals("List")){
            System.out.println(String.join(" ", dictionary.keySet()));
        }
    }
}
