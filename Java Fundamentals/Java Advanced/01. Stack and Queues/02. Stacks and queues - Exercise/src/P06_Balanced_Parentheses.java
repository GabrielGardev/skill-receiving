import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class P06_Balanced_Parentheses {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        ArrayDeque<Character> charDeque = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar == '{' || currentChar == '[' || currentChar == '(') {
                charDeque.push(currentChar);
            } else if (currentChar == '}' || currentChar == ']' || currentChar == ')') {
                if (charDeque.isEmpty()){
                    System.out.println("NO");
                    return;
                }
                char topOfDeque = charDeque.pop();
                if (topOfDeque == '{' && currentChar == '}') {
                } else if (topOfDeque == '[' && currentChar == ']') {
                } else if (topOfDeque == '(' && currentChar == ')') {
                } else {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }
}
