import java.awt.datatransfer.StringSelection;
import java.util.*;
import java.util.stream.Collectors;

public class P7_Append_Arrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split("\\s*\\|\\s*")).collect(Collectors.toList());
        Collections.reverse(input);


        List<String> printer = new ArrayList<>();
        for (String element : input) {

            String[] numbers = element.split("\\s+");
            for (String s : numbers) {
                if (!s.equals("")){
                    printer.add(s);
                }
            }
        }
        System.out.println(String.join(" ", printer));
    }
}
