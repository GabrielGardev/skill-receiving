import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P04_Salaries {
    public static List<List<Integer>> graph = new ArrayList<>();
    public static long[] salaries;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int employees = Integer.parseInt(reader.readLine());
        salaries = new long[employees];
        visited = new boolean[employees];

        int[] managersCount = new int[employees];

        for (int i = 0; i < employees; i++) {
            graph.add(new ArrayList<>());
            String line = reader.readLine();

            for (int emp = 0; emp < line.length(); emp++) {
                char letter = line.charAt(emp);

                if (letter == 'Y') {
                    managersCount[emp]++;
                    graph.get(i).add(emp);
                }
            }
        }

        List<Integer> sources = new ArrayList<>();

        for (int i = 0; i < managersCount.length; i++) {
            if (managersCount[i] == 0){
                sources.add(i);
            }
        }

        for (int source : sources) {
            dfs(source);
        }

        long sum = Arrays.stream(salaries).sum();
        System.out.println(sum);
    }

    private static void dfs(int source) {
        visited[source] = true;

        for (int child : graph.get(source)) {
            if (!visited[child]){
                dfs(child);
            }
        }
        long sum = graph.get(source).stream().mapToLong(e -> salaries[e]).sum();
        salaries[source] = sum == 0 ? 1 : sum;
    }
}
