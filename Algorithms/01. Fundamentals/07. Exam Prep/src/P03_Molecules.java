import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P03_Molecules {
    public static List<List<Integer>> graph = new ArrayList<>();
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int[] pairs = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            graph.get(pairs[0]).add(pairs[1]);
        }

        int start = Integer.parseInt(reader.readLine());

        dfs(start);

        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]){
                System.out.print(i + " ");
            }
        }
    }

    private static void dfs(int start) {
        if (!visited[start]){
            visited[start] = true;
            for (int child : graph.get(start)) {
                dfs(child);
            }
        }
    }
}
