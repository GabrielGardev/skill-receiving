import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class P05_Set_Cover {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] elements = reader.readLine().substring(10).split(", ");
        int[] universe = new int[elements.length];

        for (int i = 0; i < elements.length; i++) {
            universe[i] = Integer.parseInt(elements[i]);
        }

        int numberOfSets = Integer.parseInt(reader.readLine().substring(16));

        List<int[]> sets = new ArrayList<>();
        for (int i = 0; i < numberOfSets; i++) {
            String[] setElements = reader.readLine().split(", ");
            int[] set = new int[setElements.length];
            for (int j = 0; j < setElements.length; j++) {
                set[j] = Integer.parseInt(setElements[j]);
            }
            sets.add(set);
        }
        List<int[]> chosenSets = chooseSets(sets, universe);

        print(chosenSets);
    }

    public static List<int[]> chooseSets(List<int[]> sets, int[] universe) {
        List<int[]> result = new ArrayList<>();
        Set<Integer> universeSet = IntStream.of(universe).boxed().collect(Collectors.toSet());

        while (!universeSet.isEmpty()) {
            int notChosenCount = 0;
            int[] currentSet = sets.get(0);
            for (int[] set : sets) {
                int count = 0;
                for (int elem : set) {
                    if (universeSet.contains(elem)){
                        count++;
                    }
                }

                if (notChosenCount < count){
                    notChosenCount = count;
                    currentSet = set;
                }
            }
            result.add(currentSet);
            for (int num : currentSet) {
                universeSet.remove(num);
            }
        }

        return result;
    }

    private static void print(List<int[]> chosenSets) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Sets to take (%d):%n", chosenSets.size()));
        for (int[] set : chosenSets) {
            sb.append("{ ");
            sb.append(Arrays.toString(set).replaceAll("\\[|]", ""));
            sb.append(" }").append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}
