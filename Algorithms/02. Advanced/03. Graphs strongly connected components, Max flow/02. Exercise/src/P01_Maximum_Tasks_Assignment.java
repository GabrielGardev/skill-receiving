import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class P01_Maximum_Tasks_Assignment {
    public static boolean[][] graph;
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static int nodes;
    public static int people;
    public static int tasks;
    public static int[] parents;

    public static void main(String[] args) throws IOException {
        people = Integer.parseInt(reader.readLine().split("\\s+")[1]);
        tasks = Integer.parseInt(reader.readLine().split("\\s+")[1]);

        nodes = people + tasks + 2;
        graph = new boolean[nodes][nodes];
        fillGraph();
        findMaxFlow();

        printGraph();
    }

    private static void findMaxFlow() {
        parents = new int[graph.length];
        Arrays.fill(parents, -1);

        while (bfs(nodes - 2, nodes - 1)) {
            int node = nodes - 1;

            while (node != nodes - 2) {
                graph[parents[node]][node] = false;
                graph[node][parents[node]] = true;
                node = parents[node];
            }
        }
    }

    private static boolean bfs(int source, int target) {
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[graph.length];

        queue.offer(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int child = graph.length - 1; child >= 0; child--) {
                if (graph[node][child] && !visited[child]) {
                    visited[child] = true;
                    parents[child] = node;
                    queue.offer(child);
                }
            }
        }
        return visited[target];
    }

    private static void fillGraph() throws IOException {
        fillPeople();
        fillTasks();
        for (int i = 0; i < people; i++) {
            String line = reader.readLine();

            for (int j = 0; j < tasks; j++) {
                graph[i][people + j] = line.charAt(j) == 'Y';
            }
        }
    }

    private static void fillTasks() {
        for (int i = 0; i < tasks; i++) {
            graph[people + i][nodes - 1] = true;
        }
    }

    private static void fillPeople() {
        for (int i = 0; i < people; i++) {
            graph[nodes - 2][i] = true;
        }
    }

    private static void printGraph() {
        for (int person = 0; person < people; person++) {
            for (int task = 0; task < tasks; task++) {
                if (graph[people + task][person]){
                    System.out.printf("%c-%d%n", person + 65, task + 1);
                }
            }
        }
    }
}
