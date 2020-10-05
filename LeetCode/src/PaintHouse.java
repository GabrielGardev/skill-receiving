public class PaintHouse {
    public static int[][] costs = new int[][]{
            {17, 2, 17},
            {16, 16, 5},
            {14, 3, 19}
    };

    public static void main(String[] args) {
        int min = minCosts();
        System.out.println(min);
    }

    private static int minCosts() {

        for (int i = 1; i < costs.length; i++) {
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }

        return Math.min(Math.min(costs[2][0], costs[2][1]), costs[2][2]);
    }
}
