import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P02_Find_Bi_Connected_Components {
    public static int[][] graph;
    public static int[] parents;
    public static int[] depths;
    public static int[] lowPoints;
    public static int[] reachableCount;
    public static List<List<Integer>> supGraphs = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int nodes = Integer.parseInt(reader.readLine().split(": ")[1]);
        int edges = Integer.parseInt(reader.readLine().split(": ")[1]);

        graph = new int[nodes][nodes];
        depths = new int[nodes];
        lowPoints = new int[nodes];
        parents = new int[nodes];
        reachableCount = new int[nodes];
        Arrays.fill(parents, -1);

        for (int i = 0; i < edges; i++) {
            int[] edgeInfo = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int src = edgeInfo[0];
            int dst = edgeInfo[1];

            graph[src][reachableCount[src]++] = dst;
            graph[dst][reachableCount[dst]++] = src;
        }

        findArticulationPoints(0, 0, new ArrayList<>());
        System.out.println("Number of bi-connected components: " + supGraphs.size());
    }

    private static void findArticulationPoints(int node, int depth, List<Integer> subSet) {
        depths[node] = depth;
        lowPoints[node] = depth;

        for (int i = 0; i < reachableCount[node]; i++) {
            int child = graph[node][i];
            if (depths[child] == 0) {
                parents[child] = node;
                List<Integer> components = new ArrayList<>();
                findArticulationPoints(child, depth + 1, components);
                if (lowPoints[child] >= depths[node] || parents[child] == -1) {
                    components.add(node);
                    supGraphs.add(components);
                } else {
                    subSet.addAll(components);
                }
                lowPoints[node] = Math.min(lowPoints[node], lowPoints[child]);
            } else if (child != parents[node]) {
                lowPoints[node] = Math.min(lowPoints[node], depths[child]);
            }
        }
        subSet.add(node);
    }
}