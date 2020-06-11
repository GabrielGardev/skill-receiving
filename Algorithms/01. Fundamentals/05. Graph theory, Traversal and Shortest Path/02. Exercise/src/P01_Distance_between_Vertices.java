import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P01_Distance_between_Vertices {
    public static int[][] graph;
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static Map<Integer, Integer> indexMapper = new HashMap<>();

    public static void main(String[] args) throws IOException {


        int n = Integer.parseInt(reader.readLine());
        graph = new int[n + 1][];

        int numberOfPairs = Integer.parseInt(reader.readLine());

        fillGraph(n);

        while (numberOfPairs-- > 0) {
            int[] pairs = Arrays.stream(reader.readLine().split("-"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int source = pairs[0];
            int destination = pairs[1];

            System.out.print(String.format("{%d, %d} -> ", source, destination));

            int[] prev = new int[n + 1];
            Arrays.fill(prev, -1);

            source = indexMapper.get(source);
            destination = indexMapper.get(destination);
            bfs(source, destination, prev);

            List<Integer> path = new ArrayList<>();
            int parent = prev[destination];

            while (parent != -1){
                path.add(parent);
                parent = prev[parent];
            }
            int size = path.isEmpty() ? -1 : path.size();
            System.out.println(size);
        }
    }

    private static void bfs(int source, int destination, int[] prev) {
        boolean[] visited = new boolean[graph.length];
        Deque<Integer> queue = new ArrayDeque<>();

        queue.offer(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == destination) {
                return;
            }

            for (int i = 0; i < graph[node].length; i++) {
                int child = indexMapper.get(graph[node][i]);
                if (!visited[child]){
                    prev[child] = node;
                    visited[child] = true;
                    queue.offer(child);
                }
            }
        }
        prev[source] = -1;
    }

    private static void fillGraph(int n) throws IOException {
        for (int i = 1; i <= n; i++) {
            String[] edges = reader.readLine()
                    .split(":");

            indexMapper.put(Integer.parseInt(edges[0]), i);

            if (edges.length == 1) {
                graph[i] = new int[0];
            } else {
                graph[i] = Arrays.stream(edges[1].split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }
        }
    }
}
