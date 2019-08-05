package app.ccb.domain.entities;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {

    private Integer id;

    public BaseEntity() {
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
