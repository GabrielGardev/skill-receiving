package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "medicaments")
public class Medicament extends Patient {
    private String name;

    public Medicament(){

    }

    public Medicament(String name){
        this.name = name;
    }

    @Column(name = "medicament_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
