import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class P03_Most_Reliable_Path {
    public static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int nodes = Integer.parseInt(reader.readLine().split("\\s+")[1]);
        String[] path = reader.readLine().split(" ");
        int start = Integer.parseInt(path[1]);
        int end = Integer.parseInt(path[3]);
        int edgesCount = Integer.parseInt(reader.readLine().split("\\s+")[1]);

        graph = new int[nodes][nodes];

        for (int i = 0; i < edgesCount; i++) {
            String[] tokens = reader.readLine().split("\\s+");

            int from = Integer.parseInt(tokens[0]);
            int to = Integer.parseInt(tokens[1]);
            int weight = Integer.parseInt(tokens[2]);

            graph[from][to] = weight;
            graph[to][from] = weight;
        }

        List<Integer> result = dijkstraAlgorithm(start, end);
        System.out.println();
        String collect = result.stream()
                .map(e -> e + "")
                .collect(Collectors.joining(" -> "));
        System.out.println(collect);
    }

    public static List<Integer> dijkstraAlgorithm(int sourceNode, int destinationNode) {
        double[] distances = new double[graph.length];
        boolean[] visited = new boolean[graph.length];
        int[] prev = new int[graph.length];

        distances[sourceNode] = 100.00;
        Arrays.fill(prev, -1);

        PriorityQueue<Integer> queue = new PriorityQueue<>((f, s) -> Double.compare(distances[s], distances[f]));
        queue.offer(sourceNode);

        while (!queue.isEmpty()) {
            int minNode = queue.poll();
            visited[minNode] = true;

            int[] children = graph[minNode];

            for (int i = 0; i < children.length; i++) {
                int weight = children[i];
                if (weight != 0 && !visited[i]) {
                    double newDistance = distances[minNode] * weight / 100.00;

                    if (newDistance > distances[i]) {
                        distances[i] = newDistance;
                        prev[i] = minNode;
                    }
                    queue.offer(i);
                }
            }
        }

        System.out.printf("Most reliable path reliability: %.2f%%", distances[destinationNode]);

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
