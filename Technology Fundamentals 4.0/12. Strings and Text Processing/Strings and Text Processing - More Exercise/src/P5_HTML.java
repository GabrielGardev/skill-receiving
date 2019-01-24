import java.util.Scanner;

public class P5_HTML {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String input2 = scanner.nextLine();

        System.out.println("<h1>");
        System.out.println(String.format("  %s",input));
        System.out.println("</h1>");
        System.out.println("<article>");
        System.out.println(String.format("  %s",input2));
        System.out.println("</article>");

        while (true){
            String line = scanner.nextLine();
            if (line.equals("end of comments")){
                break;
            }

            System.out.println("<div>");
            System.out.println(String.format("  %s",line));
            System.out.println("</div>");
        }
    }
}
