import java.util.*;

public class Dijkstra {

    public static List<Integer> dijkstraAlgorithm(int[][] graph, int sourceNode, int destinationNode) {
        int[] distances = new int[graph.length];
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
        return result.size() == 1 ? null : result;
    }
}
