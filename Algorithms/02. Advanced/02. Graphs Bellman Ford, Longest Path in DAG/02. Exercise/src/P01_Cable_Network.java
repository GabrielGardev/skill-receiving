import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class P01_Cable_Network {
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

    private static int budget;
    private static int cost;
    private static boolean[] visited;

    private static Map<Integer, List<Edge>> graph = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        budget = Integer.parseInt(reader.readLine().split("\\s+")[1]);
        int nodes = Integer.parseInt(reader.readLine().split("\\s+")[1]);
        int edgesCount = Integer.parseInt(reader.readLine().split("\\s+")[1]);
        visited = new boolean[nodes];

        for (int i = 0; i < edgesCount; i++) {
            String[] tokens = reader.readLine().split("\\s+");

            int from = Integer.parseInt(tokens[0]);
            int to = Integer.parseInt(tokens[1]);
            int weight = Integer.parseInt(tokens[2]);

            Edge edge = new Edge(from, to, weight);

            if (tokens.length < 4) {
                graph.putIfAbsent(from, new ArrayList<>());
                graph.get(from).add(edge);
            } else {
                visited[from] = visited[to] = true;
            }
        }

        prim();

        System.out.println("Budget used: " + cost);
    }

    private static void prim() {
        PriorityQueue<Edge> queue = graph.values()
                .stream()
                .flatMap(List::stream)
                .filter(e -> visited[e.startNode] && !visited[e.endNode] || !visited[e.startNode] && visited[e.endNode])
                .collect(Collectors.toCollection(PriorityQueue::new));

        while (!queue.isEmpty()) {
            Edge minEdge = queue.poll();

            int from = minEdge.getStartNode();
            int to = minEdge.getEndNode();
            int weight = minEdge.getWeight();

            if (visited[from] && !visited[to]) {
                visited[to] = true;
                budget -= weight;
                if (budget <= 0) {
                    return;
                }
                cost += weight;
            } else if (!visited[from] && visited[to]) {
                visited[from] = true;
                budget -= weight;
                if (budget <= 0) {
                    return;
                }
                cost += weight;
            }

            queue = graph.values()
                    .stream()
                    .flatMap(List::stream)
                    .filter(e -> visited[e.startNode] && !visited[e.endNode] || !visited[e.startNode] && visited[e.endNode])
                    .collect(Collectors.toCollection(PriorityQueue::new));
        }
    }
}

