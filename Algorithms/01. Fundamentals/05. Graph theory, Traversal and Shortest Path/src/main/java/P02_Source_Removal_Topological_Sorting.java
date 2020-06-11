import java.util.*;

public class P02_Source_Removal_Topological_Sorting {
    public static void main(String[] args) {

    }

    public static Collection<String> topSort(Map<String, List<String>> graph) {
        List<String> sorted = new ArrayList<>();
        Map<String, Integer> predecessorsCount = getPredecessorsCount(graph);

        while (!graph.isEmpty()){
            String nodeToRemove = graph.keySet()
                    .stream()
                    .filter(e -> predecessorsCount.get(e) == 0)
                    .findFirst()
                    .orElse(null);

            if (nodeToRemove == null){
                break;
            }

            for (String child : graph.get(nodeToRemove)) {
                predecessorsCount.put(child, predecessorsCount.get(child) - 1);
            }

            graph.remove(nodeToRemove);
            sorted.add(nodeToRemove);
        }

        if (!graph.isEmpty()){
            throw new IllegalArgumentException();
        }

        return sorted;
    }

    private static Map<String, Integer> getPredecessorsCount(Map<String, List<String>> graph){
        Map<String, Integer> predecessorsCount = new HashMap<>();

        for (Map.Entry<String, List<String>> node : graph.entrySet()) {
            predecessorsCount.putIfAbsent(node.getKey(), 0);
            for (String child : node.getValue()) {
                predecessorsCount.putIfAbsent(child, 0);
                predecessorsCount.put(child, predecessorsCount.get(child) + 1);
            }
        }
        return predecessorsCount;
    }
}
