package entities;

import javax.persistence.*;

@Entity(name = "countries")
public class Country extends BaseEntityWithName {

    public Country() {
    }

    @Override
    @Id
    @Column(length = 3)
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }
}
