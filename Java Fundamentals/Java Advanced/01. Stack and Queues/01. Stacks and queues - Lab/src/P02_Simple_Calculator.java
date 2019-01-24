import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P02_Simple_Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();
        Collections.addAll(stack, line);

        while (stack.size() > 1){
            int firstNum = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int secondNum = Integer.parseInt(stack.pop());

            String result = "";
            if (operator.equals("+")){
                result = (firstNum + secondNum) + "";
            }else {
                result = (firstNum - secondNum) + "";
            }

            stack.push(result);
        }
        System.out.println(stack.pop());
    }
}
