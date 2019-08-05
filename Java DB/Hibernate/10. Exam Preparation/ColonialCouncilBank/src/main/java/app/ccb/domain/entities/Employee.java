package app.ccb.domain.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "employees")
public class Employee extends BaseEntity {

    private String firstName;

    private String lastName;

    private BigDecimal salary;

    private LocalDate startedOn;

    private Branch branch;

    private Set<Client> clients;

    public Employee() {
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setStartedOn(LocalDate startedOn) {
        this.startedOn = startedOn;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    @Column(name = "salary")
    public BigDecimal getSalary() {
        return salary;
    }

    @Column(name = "started_on")
    public LocalDate getStartedOn() {
        return startedOn;
    }

    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "branch_id", referencedColumnName = "id")
    public Branch getBranch() {
        return branch;
    }

    @ManyToMany(mappedBy = "employees", targetEntity = Client.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Client> getClients() {
        return clients;
    }


}
