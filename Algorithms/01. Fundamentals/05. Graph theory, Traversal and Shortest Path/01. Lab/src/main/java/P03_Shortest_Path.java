import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P03_Shortest_Path {
    public static List<List<Integer>> graph = new ArrayList<>();
    public static boolean[] visited;
    public static int[] prevNodes;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfNodes = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numberOfNodes + 1; i++) {
            graph.add(new ArrayList<>());
        }

        int numberOfEdges = Integer.parseInt(reader.readLine());

        fillMatrix(reader, numberOfEdges);

        int start = Integer.parseInt(reader.readLine());
        int end = Integer.parseInt(reader.readLine());

        visited = new boolean[graph.size()];
        prevNodes = new int[graph.size()];

        Arrays.fill(prevNodes, -1);

        bfs(start, end);

        print(end);
    }

    private static void print(int end) {
        List<Integer> path = new ArrayList<>();

        path.add(end);

        int prevNode = prevNodes[end];

        while (prevNode != -1){
            path.add(prevNode);
            prevNode = prevNodes[prevNode];
        }
        Collections.reverse(path);

        System.out.println("Shortest path length is: " + (path.size() - 1));
        for (Integer integer : path) {
            System.out.print(integer + " ");
        }
    }

    private static void bfs(int start, int end) {
        Deque<Integer> queue = new ArrayDeque<>();
        visited[start] = true;

        queue.offer(start);
        while (!queue.isEmpty()){
            int node = queue.poll();
            if (node == end){
                return;
            }
            for (int child : graph.get(node)) {
                if (!visited[child]){
                    visited[child] = true;
                    prevNodes[child] = node;
                    queue.offer(child);
                }
            }
        }

    }

    private static void fillMatrix(BufferedReader reader, int numberOfEdges) throws IOException {
        for (int i = 0; i < numberOfEdges; i++) {
            int[] edges = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            graph.get(edges[0]).add(edges[1]);
        }
    }
}
