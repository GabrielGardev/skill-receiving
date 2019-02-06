package P09_Cat_Lady;

public class Siamese extends Cat {
    private Double earSize;

    public Siamese(String name, Double earSize) {
        super(name);
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" %.2f", this.earSize);
    }
}
