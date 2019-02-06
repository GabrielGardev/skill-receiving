package P09_Cat_Lady;

public class Cymric extends Cat {
    private Double furLength;

    public Cymric(String name, Double furLength) {
        super(name);
        this.furLength = furLength;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" %.2f", this.furLength);
    }
}
