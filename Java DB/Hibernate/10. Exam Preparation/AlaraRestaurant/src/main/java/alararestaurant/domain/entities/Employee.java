package alararestaurant.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "employees")
public class Employee extends BaseEntity {

    private String name;
    private int age;
    private Position position;
    private Set<Order> orders;

    public Employee() {
    }

    @Column(nullable = false)
    @Size(min = 3, max = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    @Min(15)
    @Max(80)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @ManyToOne(targetEntity = Position.class ,cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id", referencedColumnName = "id", nullable = false)
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @OneToMany(mappedBy = "employee")
    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
