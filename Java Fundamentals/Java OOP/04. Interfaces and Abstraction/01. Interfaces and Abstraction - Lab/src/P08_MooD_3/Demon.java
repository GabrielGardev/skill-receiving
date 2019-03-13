package P08_MooD_3;

public class Demon extends Character<Integer> {
    private static final String CHARACTER_TYPE = "Demon";

    Demon(String username, int level, Double specialPoints) {
        super(username, CHARACTER_TYPE, level, specialPoints);
    }


    @Override
    public String toString() {
        return super.toString()
                + System.lineSeparator()
                + this.getSpecialPoints().doubleValue() * this.getLevel();
    }
}
