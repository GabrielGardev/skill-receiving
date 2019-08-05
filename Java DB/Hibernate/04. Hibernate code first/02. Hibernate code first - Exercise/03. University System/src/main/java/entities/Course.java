package entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity(name = "courses")
public class Course {

    private int id;

    private String name;

    private String description;

    private Date startDate;

    private Date endDate;

    private int credits;

    private Teacher teacher;

    private Set<Student> students;

    public Course() {
    }

    public Course(String name, String description, Date startDate, Date endDate, int credits, Teacher teacher) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.credits = credits;
        this.setTeacher(teacher);
        this.setStudents(new HashSet<>());
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    @Column(name = "name", length = 20, nullable = false)
    public String getName() {
        return name;
    }

    @Column(name = "description", length = 1000, nullable = false)
    public String getDescription() {
        return description;
    }

    @Column(name = "start_date", nullable = false)
    public Date getStartDate() {
        return startDate;
    }

    @Column(name = "end_date", nullable = false)
    public Date getEndDate() {
        return endDate;
    }

    @Min(3)
    @Column(name = "credits", nullable = false)
    public int getCredits() {
        return credits;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    public Teacher getTeacher() {
        return teacher;
    }


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "students_courses",
            joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"))
    public Set<Student> getStudents() {
        return students;
    }
}
