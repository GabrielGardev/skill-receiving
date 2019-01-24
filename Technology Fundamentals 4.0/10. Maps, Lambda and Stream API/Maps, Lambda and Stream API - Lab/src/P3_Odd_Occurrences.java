import java.util.*;

public class P3_Odd_Occurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");

        Map<String, Integer> counts = new LinkedHashMap<>();

        for (String word : words) {
            word = word.toLowerCase();

            counts.putIfAbsent(word, 0);
            counts.put(word, counts.get(word) + 1);
        }
        List<String> result = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getValue() % 2 != 0){
                result.add(entry.getKey());
            }
        }
        System.out.println(String.join(", ", result));
    }
}
