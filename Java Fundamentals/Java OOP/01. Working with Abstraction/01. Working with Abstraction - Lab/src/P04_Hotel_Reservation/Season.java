package P04_Hotel_Reservation;

public enum Season {
    Autumn(1),
    Spring(2),
    Winter(3),
    Summer(4);

    private int result;

    Season(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }
}
