import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P5_List_Manipulation_Advanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());

        while (true) {
            String[] command = scanner.nextLine().split(" ");
            if (command[0].equals("end")) {
                break;
            }

            switch (command[0]) {
                case "Contains":
                    int num = Integer.parseInt(command[1]);
                    if (numbers.contains(num)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    String evenOrOdd = command[1];
                    if (evenOrOdd.equals("even")) {
                        for (Integer number : numbers) {
                            if (number % 2 == 0) {
                                System.out.print(number + " ");
                            }
                        }
                    } else {
                        for (Integer number : numbers) {
                            if (number % 2 != 0) {
                                System.out.print(number + " ");
                            }
                        }
                    }
                    System.out.println();
                    break;
                case "Get":
                    int sum = 0;
                    for (Integer number : numbers) {
                        sum += number;
                    }
                    System.out.println(sum);
                    break;
                case "Filter":
                    String condition = command[1];
                    int number = Integer.parseInt(command[2]);

                    if (condition.equals("<")) {
                        numbers.stream().filter(e -> e < number)
                                .forEach(e -> System.out.print(e + " "));
                    } else if (condition.equals(">")) {
                        numbers.stream().filter(e -> e > number)
                                .forEach(e -> System.out.print(e + " "));
                    } else if (condition.equals(">=")) {
                        numbers.stream().filter(e -> e >= number)
                                .forEach(e -> System.out.print(e + " "));
                    } else if (condition.equals("<=")){
                        numbers.stream().filter(e -> e <= number)
                                .forEach(e -> System.out.print(e + " "));
                    }
                    System.out.println();
                    break;
                    default:
                        break;
            }
        }
    }
}
