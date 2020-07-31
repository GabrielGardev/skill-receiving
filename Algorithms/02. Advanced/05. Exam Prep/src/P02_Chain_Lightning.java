import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P02_Chain_Lightning {
    public static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static List<Edge>[] graph;
    public static Map<Integer, List<Integer>> forest = new HashMap<>();
    public static boolean[] visited;
    public static int[] damage;
    public static int max = Integer.MIN_VALUE;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int nodes = Integer.parseInt(reader.readLine());
        int edges = Integer.parseInt(reader.readLine());
        int hitCount = Integer.parseInt(reader.readLine());

        graph = new ArrayList[nodes];
        visited = new boolean[nodes];
        damage = new int[nodes];

        for (int i = 0; i < edges; i++) {
            int[] tokens = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int from = tokens[0];
            int to = tokens[1];
            int weight = tokens[2];

            if (graph[from] == null) {
                graph[from] = new ArrayList<>();
            }

            if (graph[to] == null) {
                graph[to] = new ArrayList<>();
            }

            Edge edge1 = new Edge(from, to, weight);
            Edge edge2 = new Edge(to, from, weight);

            graph[from].add(edge1);
            graph[to].add(edge2);
        }

        for (int i = 0; i < nodes; i++) {
            mfs(i);
        }

        for (int i = 0; i < hitCount; i++) {
            int[] tokens = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int node = tokens[0];
            int dmg = tokens[1];
            damageNodes(node, node, dmg);
        }
        System.out.println(max);
    }
    private static void damageNodes(int node, int next, int dmg) {
        damage[node] += dmg;

        if (dmg < 1) {
            return;
        }

        if (max < damage[node]) {
            max = damage[node];
        }

        if (forest.get(node) != null) {
            for (int child : forest.get(node)) {
                if (child != next) {
                    damageNodes(child, node, dmg / 2);
                }
            }
        }
    }

    //prim
    private static void mfs(int node) {
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        updateQueue(node, queue);

        while (!queue.isEmpty()){
            Edge minEdge = queue.poll();

            int from = minEdge.from;
            int to = minEdge.to;

            if (visited[from] && visited[to]) {
                continue;
            }

            forest.putIfAbsent(from, new ArrayList<>());
            forest.putIfAbsent(to, new ArrayList<>());

            forest.get(from).add(to);
            forest.get(to).add(from);

            if (!visited[from]) {
                updateQueue(from, queue);
            } else {
                updateQueue(to, queue);
            }
        }
    }

    private static void updateQueue(int node, PriorityQueue<Edge> queue) {
        visited[node] = true;

        if (graph[node] != null) {
            for (Edge edge : graph[node]) {
                if (!visited[edge.to]) {
                    queue.offer(edge);
                }
            }
        }
    }
}
