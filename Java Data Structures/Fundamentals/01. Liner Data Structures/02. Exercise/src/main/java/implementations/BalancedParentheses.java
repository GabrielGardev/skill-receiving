package implementations;

import interfaces.Solvable;

import java.util.Stack;

public class BalancedParentheses implements Solvable {
    private String parentheses;

    public BalancedParentheses(String parentheses) {
        this.parentheses = parentheses;
    }

    @Override
    public Boolean solve() {

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < parentheses.length(); i++) {
            char currentChar = parentheses.charAt(i);

            if (currentChar == '{' || currentChar == '(' || currentChar == '[') {
                st.push(currentChar);
            } else if (currentChar == '}' || currentChar == ')' || currentChar == ']') {
                if (st.isEmpty()) {
                    return false;
                } else if (!isMatchingPair(st.pop(), currentChar)) {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }

    private boolean isMatchingPair(char character1, char character2)
    {
        if (character1 == '(' && character2 == ')')
            return true;
        else if (character1 == '{' && character2 == '}')
            return true;
        else return character1 == '[' && character2 == ']';
    }
}
