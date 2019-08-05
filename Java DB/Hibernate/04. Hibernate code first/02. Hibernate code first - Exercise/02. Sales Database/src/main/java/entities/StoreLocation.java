package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "store_location")
public class StoreLocation extends BaseEntity {
    private String locationName;
    private Set<Sale> sales;


    public StoreLocation() {
    }

    public StoreLocation(String locationName) {
        this.locationName = locationName;
        this.sales = new HashSet<>();
    }

    @Column(name = "location_name")
    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    @OneToMany(mappedBy = "storeLocation", targetEntity = Sale.class,
    fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Sale> getSales() {
        return sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }
}
