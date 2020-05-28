import java.util.Arrays;

public class P06_8_Queens_Puzzle {
    private static final int N = 8;
    private static final int DIAGONALS_LENGTH = (N * 2) - 1;
    private static final char FREE_POSITION = '-';
    private static final char QUEEN = '*';

    public static char[][] board = new char[N][N];
    public static boolean[] attackedColumns = new boolean[N];
    public static boolean[] attackedLeftDiagonals = new boolean[DIAGONALS_LENGTH];
    public static boolean[] attackedRightDiagonals = new boolean[DIAGONALS_LENGTH];

    public static void main(String[] args) {
        fillBoard();
        placeQueens(0);
    }

    private static void placeQueens(int row) {
        if (row == N){
            printBoard();
        }else{
            for (int col = 0; col < N; col++) {
                if (canPlace(row, col)){
                    putQueen(row, col);
                    placeQueens(row + 1);
                    removeQueen(row, col);
                }
            }
        }
    }

    private static void removeQueen(int row, int col) {
        board[row][col] = FREE_POSITION;
        changeAttackedPositions(row, col, false);
    }


    private static boolean canPlace(int row, int col) {
        if (attackedColumns[col]){ return false; }
        if (attackedLeftDiagonals[getLeftDiag(row, col)]){ return false; }
        if (attackedRightDiagonals[getRightDiag(row, col)]){ return false; }

        return true;
    }

    private static int getRightDiag(int row, int col) {
        return col + row;
    }

    private static int getLeftDiag(int row, int col) {
        int leftDiag = col - row;
        return leftDiag < 0 ? leftDiag + DIAGONALS_LENGTH : leftDiag;
    }

    private static void putQueen(int row, int col) {
        board[row][col] = QUEEN;
        changeAttackedPositions(row, col, true);
    }

    private static void changeAttackedPositions(int row, int col, boolean value) {
        attackedColumns[col] = value;
        attackedLeftDiagonals[getLeftDiag(row, col)] = value;
        attackedRightDiagonals[getRightDiag(row, col)] = value;
    }

    private static void printBoard() {
        for (char[] chars : board) {
            for (char symbol : chars) {
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void fillBoard() {
        for (char[] row : board) {
            Arrays.fill(row, FREE_POSITION);
        }
    }
}