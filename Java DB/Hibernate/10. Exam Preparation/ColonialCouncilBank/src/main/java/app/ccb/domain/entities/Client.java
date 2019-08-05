package app.ccb.domain.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "clients")
public class Client extends BaseEntity {

    private String fullName;

    private Integer age;

    private BankAccount bankAccount;

    private Set<Employee> employees;

    public Client() {
        this.employees = new HashSet<>();
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void setEmployee(Set<Employee> employees) {
        this.employees = employees;
    }

    @Column(name = "full_name", nullable = false)
    public String getFullName() {
        return fullName;
    }

    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    @OneToOne(mappedBy = "client", targetEntity = BankAccount.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public BankAccount getBankAccount() {
        return bankAccount;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "employees_clients",
            joinColumns = @JoinColumn(name = "client_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "id")
    )
    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
