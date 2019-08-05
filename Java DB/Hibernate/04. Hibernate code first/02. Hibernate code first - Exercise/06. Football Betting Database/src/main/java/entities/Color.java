package entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity(name = "colors")
public class Color extends BaseEntityWithName {
    public Color(String name) {
        super(name);
    }

    public Color() {
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }
}
