import java.util.*;

public class P1_Randomize_Words {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split(" ");
        List<String> words = new ArrayList<>(Arrays.asList(line));

        Random rnd = new Random();
        for (int i = 0; i < line.length; i++) {
            int pos = rnd.nextInt(words.size());
            line[i] = words.get(pos);
            words.remove(pos);
            System.out.println(line[i]);
        }
    }
}
