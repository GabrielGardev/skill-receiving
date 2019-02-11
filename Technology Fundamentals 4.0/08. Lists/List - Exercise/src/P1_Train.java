import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P1_Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagons = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int maxCapacity = Integer.parseInt(scanner.nextLine());

        while (true){
            String[] cmd = scanner.nextLine().split(" ");
            if (cmd[0].equals("end")){
                break;
            }

            if (cmd[0].equals("Add")){
                int passengers = Integer.parseInt(cmd[1]);
                wagons.add(passengers);
            }else {
                int passengers = Integer.parseInt(cmd[0]);
                wagons.stream().filter(x -> x + passengers <= maxCapacity)
                        .findFirst()
                        .ifPresent(freeWagon -> {
                            int index = wagons.indexOf(freeWagon);
                            wagons.set(index, freeWagon + passengers);
                        });
            }
        }
        wagons.forEach(x -> System.out.print(x + " "));
    }
}
