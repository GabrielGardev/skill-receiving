package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "positions")
public class Position {
   private String id;
   private String description;

    public Position(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public Position() {
    }

    @Id
    @Column(length = 2)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "position_description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
