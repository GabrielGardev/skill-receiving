package P03_Wild_Farm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    private String livingRegion;

    public Mammal(String name, String type, Double weight, String livingRegion) {
        super(name, type, weight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %d]",
                this.getType(),
                this.getName(),
                df.format(this.getWeight()),
                this.livingRegion,
                this.getFoodEaten());
    }
}
