package P05_Jedi_Galaxy;

public class StarsManipulator {
    private Galaxy galaxy;

    public StarsManipulator(Galaxy galaxy) {
        this.galaxy = galaxy;
    }

    public void destroyStars(int evilRow, int evilCol) {

        while (evilRow >= 0 && evilCol >= 0) {

            if (IsInRange(evilRow, evilCol)){
                this.galaxy.setStar(evilRow, evilCol, new Star(0));
            }

            evilRow--;
            evilCol--;
        }
    }

    private boolean IsInRange(int evilRow, int evilCol) {

        return evilRow >= 0 && evilRow < this.galaxy.getRows()
                && evilCol >= 0 && evilCol < this.galaxy.getCols(evilRow);
    }

    public long collectStars(int[] playerPos) {
        int row = playerPos[0];
        int col = playerPos[1];

        long sum = 0;

        while (row >= 0 && col < this.galaxy.getCols(0)) {

            if (IsInRange(row, col)){
                sum += this.galaxy.getStarValue(row, col);
            }
            row--;
            col++;
        }
        return sum;
    }
}
