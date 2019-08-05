package entities;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntityWithName extends BaseEntity {
    private String name;

    public BaseEntityWithName() {
    }

    public BaseEntityWithName(String name) {
        this.name = name;
    }

    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
