import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P06_Road_Reconstruction {
    static class Graph {

        private final int V;

        private final List<List<Integer>> adj;
        int time = 0;
        static final int NIL = -1;

        Graph(int v) {
            V = v;
            adj = new ArrayList<>();
            for (int i = 0; i < v; ++i)
                adj.add(new ArrayList<>());
        }

        void addEdge(int v, int w) {
            adj.get(v).add(w);
            adj.get(w).add(v);
        }

        void bridgeUtil(int u, boolean[] visited, int[] disc, int[] low, int[] parent) {
            visited[u] = true;
            disc[u] = low[u] = ++time;

            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    parent[v] = u;
                    bridgeUtil(v, visited, disc, low, parent);
                    low[u] = Math.min(low[u], low[v]);
                    if (low[v] > disc[u])
                        System.out.println(u + " " + v);
                } else if (v != parent[u]) {
                    low[u] = Math.min(low[u], disc[v]);
                }
            }
        }

        void bridge() {
            boolean[] visited = new boolean[V];
            int[] disc = new int[V];
            int[] low = new int[V];
            int[] parent = new int[V];

            for (int i = 0; i < V; i++) {
                parent[i] = NIL;
            }

            for (int i = 0; i < V; i++)
                if (!visited[i]) {
                    bridgeUtil(i, visited, disc, low, parent);
                }
        }
    }

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int buildings = Integer.parseInt(reader.readLine());
        Graph graph = new Graph(buildings);

        int edgesCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < edgesCount; i++) {
            int[] edgeInfo = Arrays.stream(reader.readLine().split(" - ")).mapToInt(Integer::parseInt).toArray();
            graph.addEdge(edgeInfo[0], edgeInfo[1]);
        }

        System.out.println("Important streets:");
        graph.bridge();
    }
}
