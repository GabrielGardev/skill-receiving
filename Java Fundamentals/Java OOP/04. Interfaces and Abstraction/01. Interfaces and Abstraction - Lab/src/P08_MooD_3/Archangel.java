package P08_MooD_3;

public class Archangel extends Character<String> {
    private static final String CHARACTER_TYPE = "Archangel";


    Archangel(String username, int level, Integer specialPoints) {
        super(username, CHARACTER_TYPE, level, specialPoints);
    }

    @Override
    public String toString() {
        return super.toString()
                + System.lineSeparator()
                + this.getSpecialPoints().intValue() * this.getLevel();
    }
}
