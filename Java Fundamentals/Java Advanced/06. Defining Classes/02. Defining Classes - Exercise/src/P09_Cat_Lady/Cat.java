package P09_Cat_Lady;

public abstract class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getClass().getName().substring(13) + " " + this.name;
    }
}
