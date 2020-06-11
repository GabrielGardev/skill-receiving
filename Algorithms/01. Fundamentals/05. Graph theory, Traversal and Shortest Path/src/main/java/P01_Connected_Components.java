import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class P01_Connected_Components {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> graph = new ArrayList<>();
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            if (!line.isEmpty()){
                List<Integer> list = Arrays.stream(line.split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                graph.add(list);
            }else {
                graph.add(new ArrayList<>());
            }
        }

        List<Deque<Integer>> connectedComponents = getConnectedComponents(graph);
        print(connectedComponents);
    }

    private static void print(List<Deque<Integer>> connectedComponents) {
        StringBuilder sb = new StringBuilder();

        for (Deque<Integer> connectedComponent : connectedComponents) {
            sb.append("Connected component: ");
            for (Integer num : connectedComponent) {
                sb.append(num).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb.toString().trim());
    }

    public static List<Deque<Integer>> getConnectedComponents(List<List<Integer>> graph) {
        List<Deque<Integer>> components = new ArrayList<>();
        boolean[] visited = new boolean[graph.size()];

        for (int startNode = 0; startNode < graph.size(); startNode++) {
            if (!visited[startNode]){
                Deque<Integer> currentComponents = new ArrayDeque<>();
                dfs(startNode, currentComponents, visited, graph);
                components.add(currentComponents);
            }
        }
        return components;
    }

    private static void dfs(int vertex, Deque<Integer> currentComponents, boolean[] visited, List<List<Integer>> graph){
        if (!visited[vertex]){
            visited[vertex] = true;
            for (int child : graph.get(vertex)) {
                dfs(child, currentComponents, visited, graph);
            }
            currentComponents.add(vertex);
        }
    }
}
