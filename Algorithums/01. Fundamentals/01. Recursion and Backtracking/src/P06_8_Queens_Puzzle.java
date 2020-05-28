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

        int leftDiag = col - row;
        if (leftDiag < 0){
            leftDiag += DIAGONALS_LENGTH;
        }

        if (attackedLeftDiagonals[leftDiag]){ return false; }

        int rightDiag = col + row;
        if (attackedRightDiagonals[rightDiag]){ return false; }

        return true;
    }

    private static void putQueen(int row, int col) {
        board[row][col] = QUEEN;
        changeAttackedPositions(row, col, true);
    }

    private static void changeAttackedPositions(int row, int col, boolean value) {
        attackedColumns[col] = value;

        int leftDiag = col - row;
        int rightDiag = col + row;

        if (leftDiag < 0){
            leftDiag += DIAGONALS_LENGTH;
        }
        attackedLeftDiagonals[leftDiag] = value;
        attackedRightDiagonals[rightDiag] = value;
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
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                board[row][col] = FREE_POSITION;
            }
        }
    }
}
