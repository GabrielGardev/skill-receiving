package entities;

import javax.persistence.*;

@Entity(name = "towns")
public class Town extends BaseEntityWithName{
    private Country country;

    public Town(String name, Country country) {
        super(name);
        this.country = country;
    }

    public Town() {
    }

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country countryId) {
        this.country = countryId;
    }
}
