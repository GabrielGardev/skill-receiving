import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class P02_Data_Transfer {
    public static int[][] graph;
    public static int[] parents;
    public static int source;
    public static int destination;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int devices = Integer.parseInt(reader.readLine());
        int connections = Integer.parseInt(reader.readLine());

        graph = new int[devices][devices];
        parents = new int[graph.length];

        int[] tokens1 = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        source = tokens1[0];
        destination = tokens1[1];

        for (int i = 0; i < connections; i++) {
            int[] tokens2 = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int from = tokens2[0];
            int to = tokens2[1];
            int dist = tokens2[2];

            graph[from][to] = dist;
        }
        System.out.println(findMaxFlow());
    }

    public static int findMaxFlow() {
        parents = new int[graph.length];

        int maxFlow = 0;

        while (bfs()) {
            int node = destination;
            int flow = Integer.MAX_VALUE;

            while (node != source) {
                flow = Math.min(flow, graph[parents[node]][node]);
                node = parents[node];
            }
            maxFlow += flow;
            node = destination;

            while (node != source) {
                graph[parents[node]][node] -= flow;
                graph[node][parents[node]] += flow;
                node = parents[node];
            }
        }
        return maxFlow;
    }

    private static boolean bfs() {
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[graph.length];

        Arrays.fill(parents, -1);

        queue.offer(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int child = 0; child < graph.length; child++) {
                if (graph[node][child] > 0 && !visited[child]) {
                    visited[child] = true;
                    parents[child] = node;
                    queue.offer(child);
                }
            }
        }
        return visited[destination];
    }
}
