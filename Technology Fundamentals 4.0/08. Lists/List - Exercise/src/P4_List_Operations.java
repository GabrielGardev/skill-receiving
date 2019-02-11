import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P4_List_Operations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (true){
            String[] cmd = scanner.nextLine().split("\\s+");
            if (cmd[0].equals("End")){
                break;
            }

            if ("Add".equals(cmd[0])) {
                int number = Integer.parseInt(cmd[1]);
                numbers.add(number);

            } else if ("Insert".equals(cmd[0])) {
                int number = Integer.parseInt(cmd[1]);
                int index = Integer.parseInt(cmd[2]);
                if (index < 0 || index >= numbers.size()){
                    System.out.println("Invalid index");
                    continue;
                }
                numbers.add(index, number);

            } else if ("Remove".equals(cmd[0])) {
                int index = Integer.parseInt(cmd[1]);
                if (index < 0 || index >= numbers.size()){
                    System.out.println("Invalid index");
                    continue;
                }
                numbers.remove(index);
            } else if ("Shift".equals(cmd[0])) {
                int times = Integer.parseInt(cmd[2]);
                if (cmd[1].equals("left")){
                    for (int i = 0; i < times; i++) {
                        int firstNum = numbers.get(0);
                        numbers.remove(0);
                        numbers.add(firstNum);
                    }
                }else {
                    for (int i = 0; i < times; i++) {
                        int lastNum = numbers.get(numbers.size() - 1);
                        numbers.remove(numbers.size() - 1);
                        numbers.add(0, lastNum);
                    }
                }
            }
        }
        numbers.forEach(x -> System.out.print(x + " "));
    }
}
