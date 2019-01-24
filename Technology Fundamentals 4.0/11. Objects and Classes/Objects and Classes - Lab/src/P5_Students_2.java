import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P5_Students_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> students = new ArrayList<>();

        while (true){
            String[] line = scanner.nextLine().split(" ");
            if (line[0].equals("end")){
                break;
            }
            String firstName = line[0];
            String lastName = line[1];
            int age = Integer.parseInt(line[2]);
            String homeTown = line[3];
            if (isStudentExist(students, firstName, lastName)){
                Student student = getStudent(students, firstName, lastName);
                student.age = age;
                student.hometown = homeTown;
            }else {
                Student student = new Student(firstName, lastName, age, homeTown);
                students.add(student);
            }
        }
        String city = scanner.nextLine();
        for (Student student : students) {
            if (student.hometown.equals(city)){
                System.out.printf("%s %s is %d years old%n", student.firstName, student.lastName, student.age);
            }
        }

    }

    private static Student getStudent(List<Student> students, String firstName, String lastName) {
        Student existingStudent = null;

        for (Student student : students) {
            if (student.firstName.equals(firstName) && student.lastName.equals(lastName)){
                existingStudent = student;
            }
        }
        return existingStudent;
    }

    private static boolean isStudentExist(List<Student> students, String firstName, String lastName) {
        for (var student : students){
            if (student.firstName.equals(firstName) && student.lastName.equals(lastName)){
                return true;
            }
        }
        return false;
    }

    public static class Student {
         String firstName;
         String lastName;
         int age;
         String hometown;

        public Student(String firstName, String lastName, int age, String hometown) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.hometown = hometown;
        }

    }
}
