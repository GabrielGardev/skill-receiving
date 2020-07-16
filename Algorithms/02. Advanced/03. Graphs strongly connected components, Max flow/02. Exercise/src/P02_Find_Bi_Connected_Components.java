import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P02_Find_Bi_Connected_Components {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static int[][] graph;
    public static int nodes;
    public static int edges;
    public static List<List<Integer>> subGraphs = new ArrayList<>();
    public static boolean[] visited;
    public static int[] parents;
    public static int[] depths;
    public static int[] lowPoints;

    public static void main(String[] args) throws IOException {
        nodes = Integer.parseInt(reader.readLine().split("\\s+")[1]);
        edges = Integer.parseInt(reader.readLine().split("\\s+")[1]);
        graph = new int[nodes][nodes];

        fillGraph();
        List<Integer> articulationPoints = findArticulationPoints();
        System.out.println();
    }

    private static List<Integer> findArticulationPoints() {
        visited = new boolean[graph.length];
        parents = new int[graph.length];
        depths = new int[graph.length];
        lowPoints = new int[graph.length];

        Arrays.fill(parents, -1);

        discoverArticulationPoints(0, 1);

        return points;
    }

    private static void discoverArticulationPoints(int node, int depth) {
        visited[node] = true;
        depths[node] = depth;
        lowPoints[node] = depth;

        int children = 0;

        boolean isArticulationPoint = false;

        for (int child : graph[node]) {

            if (child != 0 && !visited[child]) {
                parents[child] = node;
                children++;
                discoverArticulationPoints(child, depth + 1);

                if (lowPoints[child] >= depth) {
                    isArticulationPoint = true;
                }
                lowPoints[node] = Math.min(lowPoints[node], lowPoints[child]);
            } else if (parents[node] != child) {
                lowPoints[node] = Math.min(lowPoints[node], depths[child]);
            }
        }

        if (parents[node] == -1 && children > 1 || (parents[node] != -1 && isArticulationPoint)) {
            points.add(node);
        }else {
            num++;
        }
    }

    private static void fillGraph() throws IOException {
        for (int i = 0; i < nodes; i++) {
            int[] tokens = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int source = tokens[0];
            int destination = tokens[1];

            graph[source][destination] = 1;
            graph[destination][source] = 1;
        }
    }
}