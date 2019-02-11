import java.util.Scanner;

public class P3_Characters_in_Range {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char start = scanner.nextLine().charAt(0);
        char end = scanner.nextLine().charAt(0);

        PrintChars(start, end);
    }

    private static void PrintChars(char start, char end) {
        String result = "";
        char temp = start;
        if (end < start){
            start = end;
            end = temp;
        }

        for (char i = start; i < end - 1; i++) {
            char currentChar = (char)(i + 1);
            result += currentChar + " ";
        }
        System.out.println(result);
    }
}
