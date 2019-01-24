import java.util.Arrays;
import java.util.Scanner;

public class P4_Word_Filter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = Arrays.stream(scanner.nextLine().split(" "))
                .filter(x -> x.length() % 2 == 0)
                .toArray(String[]::new);

        for (var word : words){
            System.out.println(word);
        }
    }
}
