import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class P09_Infix_to_Postfix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //( ( A + B ) * C - D ) * E
        String[] input = reader.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {
            String currentChar = input[i];

            if (currentChar.equals("(")) {
                stack.push(currentChar);
                continue;
            } else if (stack.contains("(")) {
                if (currentChar.equals(")")) {
                    while (!stack.peek().equals("(")) {
                        sb.append(stack.pop());
                        sb.append(" ");
                    }
                    stack.pop();
                    continue;
                } else {
                    if (Character.isLetter(currentChar.charAt(0)) || Character.isDigit(currentChar.charAt(0))) {
                        sb.append(currentChar);
                    } else {
                        if (!stack.isEmpty()) {
                            int topOfTheStackWeight = weight(stack.peek());
                            int currentWeight = weight(currentChar);
                            if (currentWeight > topOfTheStackWeight) {
                                stack.push(currentChar);
                                continue;
                            } else if (stack.peek().equals("(")) {
                                stack.push(currentChar);
                                continue;
                            } else {
                                while (!stack.peek().equals("(")) {
                                    sb.append(stack.pop());
                                    sb.append(" ");
                                }
                                stack.push(currentChar);
                                continue;
                            }
                        }
                    }
                }
            } else if (Character.isLetter(currentChar.charAt(0)) || Character.isDigit(currentChar.charAt(0))) {
                sb.append(currentChar);
            } else {
                if (!stack.isEmpty()) {
                    int topOfTheStackWeight = weight(stack.peek());
                    int currentWeight = weight(currentChar);
                    if (currentWeight > topOfTheStackWeight) {
                        stack.push(currentChar);
                        continue;
                    } else {
                        while (!stack.isEmpty()) {
                            sb.append(stack.pop());
                            if (!stack.isEmpty() && currentWeight > weight(stack.peek())){
                                break;
                            }
                        }
                        stack.push(currentChar);
                    }
                } else {
                    stack.push(currentChar);
                    continue;
                }
            }
            sb.append(" ");
        }
        if (sb.toString().charAt(sb.length() - 1) != ' ') {
            sb.append(' ');
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            sb.append(" ");
        }

        System.out.println(sb.toString().trim());
    }


    private static int weight(String currentChar) {
        int weight = 0;
        char temp = currentChar.charAt(0);

        switch (temp) {
            case '+':
            case '-':
                weight = 1;
                break;
            case '*':
            case '/':
                weight = 2;
                break;
            case '(':
            case ')':
                weight = 3;
                break;
        }
        return weight;
    }
}
