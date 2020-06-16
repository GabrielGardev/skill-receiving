import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P05_Break_Cycles {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static Map<String, List<String>> graph = new LinkedHashMap<>();
    public static List<String> edges = new ArrayList<>();
    public static Set<String> visited = new HashSet<>();
    public static boolean stopRecursion = false;

    public static void main(String[] args) throws IOException {
        initGraph();

        List<String> result = new ArrayList<>();
        edges.sort(Comparator.naturalOrder());

        for (String edge : edges) {

            visited.clear();
            stopRecursion = false;

            String[] edgeInfo = edge.split("-");

            String parent = edgeInfo[0];
            String child = edgeInfo[1];

            graph.get(parent).remove(child);
            graph.get(child).remove(parent);

            boolean hasCycle = checkForCycle(parent, child, null);

            if (hasCycle) {
                if (!result.contains(reversedEdge(edgeInfo))) {
                    result.add(edge);
                }
            } else {
                graph.get(parent).add(child);
                graph.get(child).add(parent);
            }
        }

        print(result);
        System.out.println();
    }

    private static boolean checkForCycle(String from, String to, String parent) {
        if (visited.contains(from)) {
            return false;
        }

        if (from.equals(to)) {
            stopRecursion = true;
            return true;
        }

        visited.add(from);

        for (String child : graph.get(from)) {
            if (child.equals(parent)) {
                continue;
            }
            checkForCycle(child, to, from);
            if (stopRecursion) {
                return true;
            }
        }
        return false;
    }

    private static void initGraph() throws IOException {
        String line = reader.readLine();

        while (line != null && !line.isEmpty()) {
            String[] relation = line.split(" -> ");
            String[] destinations = relation[1].split("\\s+");

            graph.putIfAbsent(relation[0], new ArrayList<>());
            graph.get(relation[0]).addAll(Arrays.asList(destinations));

            for (String dest : destinations) {
                edges.add(edge(relation[0], dest));
            }

            line = reader.readLine();
        }
    }

    private static String edge(String source, String dest) {
        return source + "-" + dest;
    }

    private static String reversedEdge(String[] edgeInfo) {
        return edgeInfo[1] + '-' + edgeInfo[0];
    }

    private static void print(List<String> result) {
        System.out.println("Edges to remove: " + result.size());
        for (String tuple : result) {
            String[] tupleInfo = tuple.split("-");
            System.out.println(tupleInfo[0] + " - " + tupleInfo[1]);
        }
    }
}
