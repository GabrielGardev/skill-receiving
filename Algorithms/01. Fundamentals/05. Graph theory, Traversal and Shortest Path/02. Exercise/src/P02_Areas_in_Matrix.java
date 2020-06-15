import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P02_Areas_in_Matrix {
    private static class Edge{
        private int[] source;
        private int[] dest;

        public Edge(int row, int col) {
            this.source = new int[] {row, col};
        }

        public void setDest(int row, int col) {
            this.dest = new int[] {row, col};
        }
    }

    public static List<Edge> graph = new ArrayList<>();
    public static char[][] matrix;
    public static boolean[][] visited;
    public static boolean[] visitedNode;
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        fillMatrix();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (!visited[i][j]){
                    dfs(i, j, matrix[i][j]);
                }
            }
        }

        visitedNode = new boolean[graph.size()];
        Map<Character, Integer> areas = new TreeMap<>();

        for (int i = 0; i < graph.size(); i++) {
            if (!visitedNode[i]){
                Edge edge = graph.get(i);
                int row = edge.source[0];
                int col = edge.source[1];
                char symbol = matrix[row][col];

                areas.putIfAbsent(symbol, 0);
                areas.put(symbol, areas.get(symbol) + 1);
                bfs(i);
            }
        }

        System.out.println(String.format("Areas: %d", areas.values().stream().mapToInt(e -> e).sum()));

        for (Map.Entry<Character, Integer> entry : areas.entrySet()) {
            System.out.println(String.format("Letter '%s' -> %d", entry.getKey(), entry.getValue()));
        }
    }

    private static void bfs(int index) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(index);

        visitedNode[index] = true;

        while (!queue.isEmpty()){
            int node = queue.poll();
            Edge edge = graph.get(node);
            if (edge.dest != null) {
                visitedNode[node + 1] = true;
                queue.offer(node + 1);
            }
        }
    }

    private static void dfs(int row, int col, char symbol) {
        visited[row][col] = true;

        Edge edge = new Edge(row, col);
        graph.add(edge);

        if (isInBounds(row, col + 1) && !visited[row][col + 1] && matrix[row][col + 1] == symbol){
            graph.get(graph.size() - 1).setDest(row, col + 1);
            dfs(row, col + 1, symbol);
        }
        if (isInBounds(row + 1, col) && !visited[row + 1][col] && matrix[row + 1][col] == symbol){
            graph.get(graph.size() - 1).setDest(row + 1, col);
            dfs(row + 1, col, symbol);
        }
        if (isInBounds(row, col - 1) && !visited[row][col - 1] && matrix[row][col - 1] == symbol){
            graph.get(graph.size() - 1).setDest(row, col - 1);
            dfs(row, col - 1, symbol);
        }
        if (isInBounds(row - 1, col) && !visited[row - 1][col] && matrix[row - 1][col] == symbol){
            graph.get(graph.size() - 1).setDest(row - 1, col);
            dfs(row - 1, col, symbol);
        }
    }

    private static boolean isInBounds(int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }

    private static void fillMatrix() throws IOException {
        int rows = Integer.parseInt(reader.readLine());
        matrix = new char[rows][];
        visited = new boolean[rows][];

        for (int i = 0; i < rows; i++) {
            matrix[i] = reader.readLine().toCharArray();
            visited[i] = new boolean[matrix[i].length];
        }
    }
}
