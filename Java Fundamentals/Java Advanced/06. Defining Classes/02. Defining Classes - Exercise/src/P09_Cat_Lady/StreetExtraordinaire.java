package P09_Cat_Lady;

public class StreetExtraordinaire extends Cat {
    private Double decibelsOfMeows;

    public StreetExtraordinaire(String name, Double decibelsOfMeows) {
        super(name);
        this.decibelsOfMeows = decibelsOfMeows;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" %.2f", this.decibelsOfMeows);
    }
}
