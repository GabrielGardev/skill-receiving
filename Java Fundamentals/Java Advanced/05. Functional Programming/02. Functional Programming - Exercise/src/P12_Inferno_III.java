import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P12_Inferno_III {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BiFunction<List<Integer>, Integer, List<Integer>> sumLeft = (list, num) -> {
            List<Integer> marked = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    if (list.get(i).equals(num)) {
                        marked.add(i);
                    }
                } else if (list.get(i) + list.get(i - 1) == num) {
                    marked.add(i);
                }
            }
            return marked;
        };

        BiFunction<List<Integer>, Integer, List<Integer>> sumRight = (list, num) -> {
            List<Integer> marked = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                if (i == list.size() - 1) {
                    if (list.get(i).equals(num)) {
                        marked.add(i);
                    }
                } else if (list.get(i) + list.get(i + 1) == num) {
                    marked.add(i);
                }
            }
            return marked;
        };

        BiFunction<List<Integer>, Integer, List<Integer>> sumLeftAndRight = (list, num) -> {
            List<Integer> marked = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                if (list.size() == 1) {
                    if (list.get(i).equals(num)) {
                        marked.add(i);
                    }
                } else if (i == 0) {
                    if (list.get(i) + list.get(i + 1) == num) {
                        marked.add(i);
                    }
                } else if (i == list.size() - 1) {
                    if (list.get(i) + list.get(i - 1) == num) {
                        marked.add(i);
                    }
                } else if (list.get(i) + list.get(i + 1) + list.get(i - 1) == num) {
                    marked.add(i);
                }
            }
            return marked;
        };

        List<Integer> gems = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        ArrayDeque<String> stack = new ArrayDeque<>();

        while (true) {
            String[] line = reader.readLine().split(";");
            String cmd = line[0];
            if ("Forge".equals(cmd)) {
                break;
            }

            String summing = line[1] + ";" + line[2];

            if (cmd.equals("Exclude")) {
                stack.push(summing);
            } else {
                stack.remove(summing);
            }
        }

        Set<Integer> marked = new LinkedHashSet<>();

        while (!stack.isEmpty()) {
            if (gems.isEmpty()) {
                return;
            }
            String[] line = stack.pop().split(";");
            String cmd = line[0];
            int num = Integer.parseInt(line[1]);

            List<Integer> temp = null;

            if (cmd.equals("Sum Left")) {
                temp = sumLeft.apply(gems, num);
            } else if (cmd.equals("Sum Right")) {
                temp = sumRight.apply(gems, num);
            } else if (cmd.equals("Sum Left Right")) {
                temp = sumLeftAndRight.apply(gems, num);
            }
            if (temp != null && temp.size() != 0) {
                marked.addAll(temp);
            }
        }

        if (marked.size() > 1) {
            marked = marked.stream().sorted(Comparator.reverseOrder())
                    .collect(Collectors.toCollection(LinkedHashSet::new));
        }

        for (int num : marked) {
            gems.remove(num);
        }

        gems.forEach(x -> System.out.print(x + " "));
    }
}
