import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P03_Molecules_with_adjacency_matrix {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(reader.readLine());
        int connections = Integer.parseInt(reader.readLine());

        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < connections; i++) {
            int[] connection = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int source = connection[0];
            int dest = connection[1];

            graph[source][dest] = 1;
        }

        int start = Integer.parseInt(reader.readLine());
        dfs(start);

        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]){
                System.out.print(i + " ");
            }
        }
    }

    private static void dfs(int node) {

        if (!visited[node]) {
            visited[node] = true;

            for (int i = 0; i < graph[node].length; i++) {
                if (graph[node][i] != 0){
                    dfs(i);
                }
            }
        }
    }
}