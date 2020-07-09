import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P04_Cheap_Town_Tour {
    public static int[][] graph;
    public static int nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        nodes = Integer.parseInt(reader.readLine());
        int n = Integer.parseInt(reader.readLine());

        graph = new int[nodes][nodes];

        for (int i = 0; i < n; i++) {
            int[] tokens = Arrays.stream(reader.readLine().split(" - "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int source = tokens[0];
            int destination = tokens[1];
            int weight = tokens[2];

            graph[source][destination] = weight;
//            graph[destination][source] = weight;
        }

        System.out.println(kruskal());
    }

    private static String kruskal() {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(n -> graph[n[0]][n[1]]));

        int cost = 0;
        int[] parents = new int[nodes];

        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        for (int row = 0; row < graph.length; row++) {
            for (int col = 0; col < graph[row].length; col++) {
                if (graph[row][col] != 0){
                    queue.offer(new int[]{row, col, graph[row][col]});
                }
            }
        }

        while (!queue.isEmpty()){
            int[] minEdge = queue.poll();

            int from = minEdge[0];
            int to = minEdge[1];
            int weight = minEdge[2];

            int firstRoot = findRoot(from, parents);
            int secondRoot = findRoot(to, parents);

            if (firstRoot != secondRoot){
                cost += weight;
                parents[firstRoot] = secondRoot;
            }
        }
        return "Total cost: " + cost;
    }
    public static int findRoot(int node, int[] parents) {
        int root = node;
        while (parents[root] != root){
            root = parents[root];
        }

        while (node != root){
            int oldParent = parents[node];
            parents[node] = root;
            node = oldParent;
        }
        return node;
    }
}