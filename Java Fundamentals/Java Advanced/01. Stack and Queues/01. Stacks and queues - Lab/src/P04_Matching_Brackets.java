import java.util.ArrayDeque;
import java.util.Scanner;

public class P04_Matching_Brackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '('){
                stack.push(i);
            }else if (line.charAt(i) == ')'){
                int startIndex = stack.pop();
                String result = line.substring(startIndex, i + 1);
                System.out.println(result);
            }
        }
    }
}
