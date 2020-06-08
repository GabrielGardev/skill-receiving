import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P05_Find_All_Paths_in_a_Labyrinth {
    public static List<Character> paths = new ArrayList<>();
    public static char[][] labyrinth;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        labyrinth = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            labyrinth[row] = scanner.nextLine().toCharArray();
        }

        findPath(0, 0, 'S');
    }

    private static void findPath(int row, int col, char direction) {
        if (!isInBounds(row, col)){
            return;
        }

        paths.add(direction);

        if (isExit(row, col)){
            printPath();
        }else if (isFree(row, col) && !isMarked(row, col)){
            labyrinth[row][col] = 'V';
            findPath(row, col + 1, 'R');
            findPath(row + 1, col, 'D');
            findPath(row, col - 1, 'L');
            findPath(row - 1, col, 'U');
            labyrinth[row][col] = '-';
        }
        paths.remove(paths.size() - 1);
    }

    private static void printPath() {
        for (Character direction : paths) {
            if (!direction.equals('S')){
                System.out.print(direction);
            }
        }
        System.out.println();
    }

    private static boolean isMarked(int row, int col) {
        return labyrinth[row][col] == 'V';
    }

    private static boolean isFree(int row, int col) {
        return labyrinth[row][col] == '-';
    }

    private static boolean isExit(int row, int col) {
        return labyrinth[row][col] == 'e';
    }

    private static boolean isInBounds(int row, int col) {
        return row >= 0 && row < labyrinth.length && col >= 0 && col < labyrinth[row].length;
    }
}
