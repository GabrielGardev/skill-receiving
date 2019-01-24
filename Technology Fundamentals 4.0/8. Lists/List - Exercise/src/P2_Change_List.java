import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P2_Change_List {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine()
                        .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (true) {
            String[] cmd = scanner.nextLine().split("\\s+");
            if (cmd[0].equals("end")) {
                break;
            }

            if (cmd[0].equals("Delete")) {
                int element = Integer.parseInt(cmd[1]);
                numbers = numbers.stream().filter(x -> x != element).collect(Collectors.toList());

            } else {
                int element = Integer.parseInt(cmd[1]);
                int position = Integer.parseInt(cmd[2]);
                if (position < numbers.size() && position >= 0){
                    numbers.add(position, element);
                }
            }
        }
            numbers.forEach(x -> System.out.print(x + " "));
    }
}
