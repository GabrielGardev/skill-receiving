import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P03_Black_Mesa {
    public static List<List<Integer>> graph = new ArrayList<>();
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine().trim());
        int m = Integer.parseInt(reader.readLine().trim());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int[] connections = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            graph.get(connections[0]).add(connections[1]);
        }

        visited = new boolean[n+ 1];

        int start = Integer.parseInt(reader.readLine().trim());
        int end = Integer.parseInt(reader.readLine().trim());
        shortestPath(start, end);

        visited = new boolean[n + 1];
        markNodes(start);

        sb.append(System.lineSeparator());
        printAllVisitedVersions();
    }

    private static void printAllVisitedVersions() {
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]){
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    private static void markNodes(int start) {
        if (!visited[start]){
            visited[start] = true;
            for (int child : graph.get(start)) {
                markNodes(child);
            }
        }
    }

    private static void shortestPath(int start, int end) {
        Deque<Integer> queue = new ArrayDeque<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()){
            int node = queue.poll();
            sb.append(node).append(" ");

            if (node == end){
                return;
            }
            for (int child : graph.get(node)) {
                if (!visited[child]){
                    visited[child] = true;
                    queue.offer(child);
                }
            }
        }

    }
}
