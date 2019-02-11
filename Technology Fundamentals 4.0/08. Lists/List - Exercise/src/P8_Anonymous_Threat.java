import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P8_Anonymous_Threat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        while (true) {
            String[] cmd = scanner.nextLine().split("\\s+");
            if (cmd[0].equals("3:1")) {
                break;
            }
            List<String> result = new ArrayList<>();
            if (cmd[0].equals("merge")) {
                int startIndex = Math.max(0, Integer.parseInt(cmd[1]));
                int endIndex = Math.min(input.size() - 1, Integer.parseInt(cmd[2]));
                if (Integer.parseInt(cmd[1]) >= input.size()) {
                    continue;
                }

                if (startIndex > 0) {
                    result.addAll(input.subList(0, startIndex));
                }
                String merged = input.subList(startIndex, endIndex + 1)
                        .stream()
                        .reduce((r, x) -> r + x)
                        .get();
                result.add(merged);

                if (endIndex + 1 < input.size()) {
                    result.addAll(input.subList(endIndex + 1, input.size()));
                }

                input = result;
            } else {
                int indexOfElement = Integer.parseInt(cmd[1]);
                int partitions = Integer.parseInt(cmd[2]);
                String word = input.get(indexOfElement);
                if (partitions > word.length()){
                    partitions = word.length();
                }else if (partitions == 0){
                    continue;
                }

                int divider = word.length() / partitions;

                if (word.length() % partitions == 0) {
                    for (int i = 0; i < partitions; i++) {
                        result.add(word.substring(0, divider));
                        word =word.substring(divider);
                    }
                }else {
                    for (int i = 0; i < partitions; i++) {
                        if (i == partitions - 1){
                            result.add(word);
                            break;
                        }
                        result.add(word.substring(0, divider));
                        word = word.substring(divider);
                    }
                }
                input.remove(indexOfElement);
                input.addAll(indexOfElement, result);
            }
        }
        input.forEach(x -> System.out.print(x + " "));
    }
}
