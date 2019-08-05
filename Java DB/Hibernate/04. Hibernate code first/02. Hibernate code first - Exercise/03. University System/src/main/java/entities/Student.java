package entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "students")
public class Student extends Person {

    private BigDecimal averageGrade;

    private int attendance;

    private Set<Course> courses;

    public Student() {
    }

    public Student(String firstName, String lastName, String phoneNumber, BigDecimal averageGrade, int attendance) {
        super(firstName, lastName, phoneNumber);
        this.setCourses(new HashSet<>());
        this.setAverageGrade(averageGrade);
        this.setAttendance(attendance);
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public void setAverageGrade(BigDecimal averageGrade) {
        this.averageGrade = averageGrade;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public void addCourse(Course course) {

        this.courses.add(course);
    }

    @Column(name = "average_grade")
    public BigDecimal getAverageGrade() {
        return averageGrade;
    }

    @Column(name = "attendance")
    public int getAttendance() {
        return attendance;
    }

    @ManyToMany(mappedBy = "students",
            targetEntity = Course.class,
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    public Set<Course> getCourses() {
        return courses;
    }
}
