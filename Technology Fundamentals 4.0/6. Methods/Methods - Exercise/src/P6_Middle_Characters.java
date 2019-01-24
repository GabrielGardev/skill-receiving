import java.util.Scanner;

public class P6_Middle_Characters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();

        GetMiddleLetter(word);
    }

    private static void GetMiddleLetter(String word) {
        String result = "";
        if (word.length() % 2 == 0) {
            // get 2 middle letters
            int middle = word.length() / 2 - 1;
            result = word.charAt(middle) + "" + word.charAt(middle + 1) + "";
        } else {
            // just one
            result = word.charAt(word.length() / 2) + "";
        }
        System.out.println(result);
    }
}
