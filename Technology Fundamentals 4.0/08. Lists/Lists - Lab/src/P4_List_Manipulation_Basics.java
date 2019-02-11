
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P4_List_Manipulation_Basics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());

        while (true) {
            String line = scanner.nextLine();
            if (line.equals("end")) {
                break;
            }
            String[] command = line.split(" ");
            int num = Integer.parseInt(command[1]);

            switch (command[0]) {
                case "Add":
                    numbers.add(num);
                    break;
                case "Remove":
                    for (Integer number : numbers) {
                        if (number == num){
                            numbers.remove(number);
                            break;
                        }
                    }
                    break;
                case "RemoveAt":
                    numbers.remove(num);
                    break;
                case "Insert":
                    int index = Integer.parseInt(command[2]);
                    numbers.add(index, num);
                    break;
            }
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
