import java.util.*;

public class KruskalAlgorithm {

    public static List<Edge> kruskal(int numberOfVertices, List<Edge> edges) {
        edges.sort(Edge::compareTo);

        List<Edge> forest = new ArrayList<>();
        int[] parents = new int[numberOfVertices];

        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        for (Edge edge : edges) {
            int source = edge.getStartNode();
            int dest = edge.getEndNode();

            int firstRoot = findRoot(source, parents);
            int secondRoot = findRoot(dest, parents);

            if (firstRoot != secondRoot){
                forest.add(edge);
                parents[firstRoot] = secondRoot;
            }
        }

        return forest;
    }

    public static int findRoot(int node, int[] parents) {
        while (parents[node] != node){
            node = parents[node];
        }

        return node;
    }
}
