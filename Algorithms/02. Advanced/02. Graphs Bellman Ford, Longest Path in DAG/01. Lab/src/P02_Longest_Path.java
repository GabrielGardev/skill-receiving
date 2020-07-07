import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class P02_Longest_Path {
    public static int[][] DAG;
    public static int source;
    public static int destination;

    public static void main(String[] args) throws IOException {
        init();

        printLongestPath();
    }

    private static void printLongestPath() {
        int[] distance = new int[DAG.length];
        Arrays.fill(distance, Integer.MIN_VALUE);
        distance[source] = 0;

        boolean[] visited = new boolean[DAG.length];

        Deque<Integer> sorted = new ArrayDeque<>();

        for (int i = 1; i < DAG.length; i++) {
            topologicalSort(i, sorted, visited);
        }

        while (!sorted.isEmpty()) {
            int vertex = sorted.pop();
            for (int i = 1; i < DAG[vertex].length; i++) {
                int weight = DAG[vertex][i];
                if (weight != 0) {
                    if (distance[vertex] + weight > distance[i]) {
                        distance[i] = distance[vertex] + weight;
                    }
                }
            }
        }

        System.out.println(distance[destination]);
    }

    private static void topologicalSort(int node, Deque<Integer> sorted, boolean[] visited) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;

        for (int i = 1; i < DAG[node].length; i++) {
            if (DAG[node][i] != 0) {
                topologicalSort(i, sorted, visited);
            }
        }
        sorted.push(node);
    }

    private static void init() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int nodes = Integer.parseInt(reader.readLine());
        DAG = new int[nodes + 1][nodes + 1];
        int edgesCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < edgesCount; i++) {
            int[] edgeInfo = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int from = edgeInfo[0];
            int to = edgeInfo[1];
            int weight = edgeInfo[2];

            DAG[from][to] = weight;
        }

        source = Integer.parseInt(reader.readLine());
        destination = Integer.parseInt(reader.readLine());
    }
}
