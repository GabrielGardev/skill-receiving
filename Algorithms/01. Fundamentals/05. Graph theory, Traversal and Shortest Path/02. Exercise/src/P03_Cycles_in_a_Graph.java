import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P03_Cycles_in_a_Graph {
    public static Map<String, List<String>> graph = new HashMap<>();
    public static Set<String> visited = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        String source = null;

        while (!line.equals("End")) {
            String[] strings = line.split("-");

            if (source == null) {
                source = strings[0];
            }
            graph.putIfAbsent(strings[0], new ArrayList<>());
            graph.putIfAbsent(strings[1], new ArrayList<>());

            graph.get(strings[0]).add(strings[1]);
            graph.get(strings[1]).add(strings[0]);

            line = reader.readLine();
        }

        boolean hasCycle = dfs(source, "none");

        System.out.println("Acyclic: " + (hasCycle ? "No" : "Yes"));
    }

    private static boolean dfs(String node, String parent) {
        visited.add(node);

        if (graph.get(node) == null){
            return false;
        }

        for (String neighbor : graph.get(node)) {
            if (neighbor.equals(parent)){
                continue;
            }

            if (visited.contains(neighbor)) {
                return true;
            }

            if (dfs(neighbor, node)){
                return true;
            }
        }
        return false;
    }
}
