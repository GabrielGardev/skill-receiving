import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P02_Modified_Kruskal_Algorithm {
    private static class Edge implements Comparable<Edge> {
        private int startNode;
        private int endNode;
        private int weight;

        public Edge(int startNode, int endNode, int weight) {
            this.startNode = startNode;
            this.endNode = endNode;
            this.weight = weight;
        }

        public int getStartNode() {
            return this.startNode;
        }

        public void setStartNode(int startNode) {
            this.startNode = startNode;
        }

        public int getEndNode() {
            return this.endNode;
        }

        public void setEndNode(int endNode) {
            this.endNode = endNode;
        }

        public int getWeight() {
            return this.weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.getWeight());
        }
    }

    private static final List<Edge> edges = new ArrayList<>();
    private static boolean[] visited;
    private static int nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        nodes = Integer.parseInt(reader.readLine().split("\\s+")[1]);
        int edgesCount = Integer.parseInt(reader.readLine().split("\\s+")[1]);
        visited = new boolean[nodes];

        for (int i = 0; i < edgesCount; i++) {
            String[] tokens = reader.readLine().split("\\s+");

            int from = Integer.parseInt(tokens[0]);
            int to = Integer.parseInt(tokens[1]);
            int weight = Integer.parseInt(tokens[2]);

            Edge edge = new Edge(from, to, weight);

            edges.add(edge);
        }

        List<Edge> forest = kruskal();
        print(forest);
    }

    private static void print(List<Edge> forest) {
        System.out.println("Minimum spanning forest weight: " +
                forest.stream().mapToInt(e -> e.weight).sum());
    }

    private static List<Edge> kruskal() {
        edges.sort(Edge::compareTo);

        List<Edge> forest = new ArrayList<>();
        int[] parents = new int[nodes];

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
