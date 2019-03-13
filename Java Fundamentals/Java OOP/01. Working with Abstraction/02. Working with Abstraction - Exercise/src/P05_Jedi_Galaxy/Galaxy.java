package P05_Jedi_Galaxy;

public class Galaxy {
    private Star[][] stars;

    public Galaxy(int rows, int cols) {
        this.stars = new Star[rows][cols];
        this.fillStars();
    }

    private void fillStars(){
        int star = 0;
        for (int i = 0; i < this.stars.length; i++) {
            for (int j = 0; j < this.stars[0].length; j++) {
                this.stars[i][j] = new Star(star++);
            }
        }
    }
    public int getRows(){
        return this.stars.length;
    }

    public int getCols(int row){
        return this.stars[row].length;
    }

    public void setStar(int row, int col, Star star) {
        if (IsInRange(row, col)){
            this.stars[row][col] = star;
        }
    }

    private boolean IsInRange(int row, int col) {
        return row >= 0 && row < this.stars.length
                && col >= 0 && col < this.stars[row].length;
    }

    public long getStarValue(int row, int col) {
        if (IsInRange(row, col)){
           return this.stars[row][col].getValue();
        }
        return 0;
    }
}
