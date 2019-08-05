package app.ccb.domain.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "branches")
public class Branch extends BaseEntity {

    private String name;

    private Set<Employee> employees;

    public Branch() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    @OneToMany(mappedBy = "branch", targetEntity = Employee.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Employee> getEmployees() {
        return employees;
    }
}
