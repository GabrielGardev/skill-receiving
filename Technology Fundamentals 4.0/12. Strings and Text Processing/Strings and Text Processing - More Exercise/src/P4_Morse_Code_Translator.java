import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P4_Morse_Code_Translator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split(" \\| ");

        String[] morseSymbols = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.",
                "--.", "....", "..", ".---", "-.-", ".-..",
                "--", "-.", "---", ".--.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-",
                "-.--", "--.."};
        ArrayList<String> symbols = new ArrayList<>(Arrays.asList(morseSymbols));

        StringBuilder sb = new StringBuilder();
        for (String s : line) {
            String[] morseLetters = s.split("\\s+");

            for (String morseLetter : morseLetters) {
                int index = symbols.indexOf(morseLetter) + 65;
                char letter = (char)index;
                sb.append(letter);
            }
            sb.append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}

