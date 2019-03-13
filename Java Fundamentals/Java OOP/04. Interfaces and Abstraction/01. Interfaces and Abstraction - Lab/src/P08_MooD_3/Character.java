package P08_MooD_3;

public abstract class Character<P> implements GameObject<P> {
    private String username;
    private String characterType;
    private int level;
    private Number specialPoints;
    private P hashedPassword;


    Character(String username, String characterType, int level, Number specialPoints) {
        this.username = username;
        this.characterType = characterType;
        this.level = level;
        this.specialPoints = specialPoints;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getCharacterType() {
        return this.characterType;
    }

    @Override
    public Number getSpecialPoints() {
        return this.specialPoints;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public P getHashedPassword() {
        return this.hashedPassword;
    }

    public void setHashedPassword(P pass) {
        this.hashedPassword = pass;
    }

    @Override
    public String toString() {
        return String.format("\"\"%s\"\" | \"%s\" -> %s",
                this.getUsername(),
                this.getHashedPassword().toString(),
                this.getCharacterType());
    }
}
