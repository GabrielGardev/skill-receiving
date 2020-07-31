import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P01_Le_Tour_de_Sofia {

    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static int[] distances;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int nodes = Integer.parseInt(reader.readLine());
        int edges = Integer.parseInt(reader.readLine());
        int source = Integer.parseInt(reader.readLine());
        distances = new int[nodes];
        visited = new boolean[nodes];

        for (int i = 0; i < edges; i++) {
            int[] streetInfo = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            graph.putIfAbsent(streetInfo[0], new ArrayList<>());
            graph.get(streetInfo[0]).add(streetInfo[1]);
        }

        bfs(source);

        if (distances[source] != 0) {
            System.out.println(distances[source]);
        } else {
            int visitedNodes = 0;
            for (boolean node : visited) {
                if (node) {
                    visitedNodes++;
                }
            }

            System.out.println(visitedNodes);
        }
    }

    private static void bfs(int source) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(source);

        visited[source] = true;
        distances[source] = 0;

        while (!queue.isEmpty()) {
            int parent = queue.poll();
            List<Integer> children = graph.get(parent);

            if (children != null) {
                for (Integer child : children) {
                    if (!visited[child]) {
                        visited[child] = true;
                        queue.offer(child);
                        distances[child] = distances[parent] + 1;
                    } else if (child == source) {
                        distances[child] = distances[parent] + 1;
                        return;
                    }
                }
            }
        }
    }
}