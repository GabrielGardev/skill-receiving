package entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "teachers")
public class Teacher extends Person {

    private String email;

    private BigDecimal salaryPerHour;

    private Set<Course> courses;

    public Teacher() {
    }

    public Teacher(String firstName, String lastName, String phoneNumber, String email, BigDecimal salaryPerHour) {
        super(firstName, lastName, phoneNumber);
        this.setCourses(new HashSet<>());
        this.setEmail(email);
        this.setSalaryPerHour(salaryPerHour);
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }


    public void setSalaryPerHour(BigDecimal salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    @Column(name = "email", length = 30)
    public String getEmail() {
        return email;
    }

    @Column(name = "salary_per_hour")
    public BigDecimal getSalaryPerHour() {
        return salaryPerHour;
    }

    @OneToMany(mappedBy = "teacher", targetEntity = Course.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Set<Course> getCourses() {
        return courses;
    }
}
