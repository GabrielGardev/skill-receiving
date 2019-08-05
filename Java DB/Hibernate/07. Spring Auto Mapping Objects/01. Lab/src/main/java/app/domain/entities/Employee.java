package app.domain.entities;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {

    private Long id;

    private String firstName;

    private String lastName;

    private LocalDate birthday;

    private BigDecimal salary;

    private Boolean isOnHoliday;

    private String address;

    private Employee manager;

    private List<Employee> minions;

    public Employee() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setOnHoliday(Boolean onHoliday) {
        isOnHoliday = onHoliday;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public void setMinions(List<Employee> minions) {
        this.minions = minions;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    @Column(name = "birthday")
    public LocalDate getBirthday() {
        return birthday;
    }

    @Column(name = "salary")
    public BigDecimal getSalary() {
        return salary;
    }

    @Column(name = "is_on_holiday")
    public Boolean getOnHoliday() {
        return isOnHoliday;
    }

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    public Employee getManager() {
        return manager;
    }

    @OneToMany(mappedBy = "manager", targetEntity = Employee.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public List<Employee> getMinions() {
        return minions;
    }
}
