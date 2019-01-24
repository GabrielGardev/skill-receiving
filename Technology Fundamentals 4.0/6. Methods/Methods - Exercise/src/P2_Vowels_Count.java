import java.util.Scanner;

public class P2_Vowels_Count {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();

        CountVowelsInWord(word);
    }

    private static void CountVowelsInWord(String word) {
        int counter = 0;
            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);

                switch (currentChar) {
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case 'U':
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                        counter++;
                }
            }
        System.out.println(counter);
    }
}
