import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P01_Food_Program {
    public static int[][] graph;
    public static int[] distances;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int zones = Integer.parseInt(reader.readLine());
        int roads = Integer.parseInt(reader.readLine());

        graph = new int[zones][zones];
        distances = new int[graph.length];

        int[] tokens1 = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sourceNode = tokens1[0];
        int destinationNode = tokens1[1];

        for (int i = 0; i < roads; i++) {
            int[] tokens2 = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int from = tokens2[0];
            int to = tokens2[1];
            int dist = tokens2[2];

            graph[from][to] = dist;
            graph[to][from] = dist;
        }

        List<Integer> result = dijkstraAlgorithm(sourceNode, destinationNode);
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println(distances[destinationNode]);
    }

    public static List<Integer> dijkstraAlgorithm(int sourceNode, int destinationNode) {
        int[] prev = new int[graph.length];
        boolean[] visited = new boolean[graph.length];

        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);
        distances[sourceNode] = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(node -> distances[node]));
        queue.offer(sourceNode);

        while (!queue.isEmpty()) {
            int parent = queue.poll();
            visited[parent] = true;

            int[] children = graph[parent];

            for (int i = 0; i < children.length; i++) {
                if (children[i] != 0 && !visited[i]) {
                    queue.offer(i);

                    int newDistance = distances[parent] + children[i];

                    if (newDistance < distances[i]) {
                        distances[i] = newDistance;
                        prev[i] = parent;
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        result.add(destinationNode);

        int prevNode = prev[destinationNode];

        while (prevNode != -1){
            result.add(prevNode);
            prevNode = prev[prevNode];
        }
        Collections.reverse(result);
        return result;
    }
}