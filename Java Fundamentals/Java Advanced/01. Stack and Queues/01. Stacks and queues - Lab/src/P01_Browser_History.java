import java.util.ArrayDeque;
import java.util.Scanner;

public class P01_Browser_History {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<String> stack = new ArrayDeque<>();
        while (true){
            String input = scanner.nextLine();
            if (input.equals("Home")){
                break;
            }

            if (input.equals("back")){
                if (stack.size() <= 1){
                    System.out.println("no previous URLs");
                }else {
                    stack.pop();
                    System.out.println(stack.peek());
                }
            }else {
                stack.push(input);
                System.out.println(input);
            }

        }
    }
}
