import entities.Course;
import entities.Student;
import entities.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("university_db");
        EntityManager em = managerFactory.createEntityManager();

        //some random db filling

        Teacher teacher = new Teacher("Alen", "Paunov", "0882314245", "alenkata@abv.bg", new BigDecimal("50"));
        Teacher teacher1 = new Teacher("Doncho", "Minkov", "0891231231", "doncho@abv.bg", new BigDecimal("60"));
        Course course = new Course("Hibernate", "very interesting", new Date(), new Date(), 15, teacher);
        Course course1 = new Course("MySQL", "boring AF", new Date(), new Date(), 9, teacher1);
        Student student = new Student("Sergei", "Stanishev", "0892945039", new BigDecimal("6.00"), 11);
        Student student1 = new Student("Root", "Rolandov", "0883213113", new BigDecimal("5.00"), 15);

        Object[] objects = new Object[]{teacher, teacher1, student, student1, course, course1};

        course.addStudent(student);
        course.addStudent(student1);

        inTransaction(em, () -> Arrays.stream(objects).forEach(em::persist));
    }

    private static void inTransaction(EntityManager em, Runnable... runnables) {

        em.getTransaction().begin();

        Arrays.stream(runnables).forEach(Runnable::run);

        em.getTransaction().commit();
        em.close();
    }
}
