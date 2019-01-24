import java.util.ArrayDeque;
        import java.util.Scanner;

public class P08_Browser_History_Upgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> backs = new ArrayDeque<>();
        ArrayDeque<String> forwards = new ArrayDeque<>();

        while (true){
            String input = scanner.nextLine();
            if (input.equals("Home")){
                break;
            }

            if (input.equals("back")){
                if (backs.size() <= 1){
                    System.out.println("no previous URLs");
                }else {
                    forwards.addFirst(backs.peek());
                    backs.pop();
                    System.out.println(backs.peek());
                }
            }else if (input.equals("forward")){
                if (forwards.size() < 1){
                    System.out.println("no next URLs");
                }else {
                    backs.push(forwards.peek());
                    System.out.println(forwards.poll());
                }
            }else {
                forwards.clear();
                backs.push(input);
                System.out.println(input);
            }

        }
    }
}
