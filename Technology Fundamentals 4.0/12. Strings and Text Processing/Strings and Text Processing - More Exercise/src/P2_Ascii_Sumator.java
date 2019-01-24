import java.util.Scanner;

public class P2_Ascii_Sumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start = scanner.nextLine().charAt(0);
        int end = scanner.nextLine().charAt(0);

        if (end < start){
            int temp = start;
            start = end;
            end = temp;
        }

        String line = scanner.nextLine();
        int sum = 0;
        for (int i = 0; i < line.length(); i++) {
            char currentChar = line.charAt(i);
            if (currentChar > start && currentChar < end){
                sum += currentChar;
            }
        }
        System.out.println(sum);
    }
}
