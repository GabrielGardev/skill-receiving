import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P5_Students {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> students = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");

            Student student = new Student(line[0],line[1],Double.parseDouble(line[2]));
            students.add(student);
        }

        students.stream()
                .sorted((a,b) -> Double.compare(b.getGrade(), a.getGrade()))
                .forEach(x -> System.out.println(x.toString()));

    }
    static class Student {
        private String firstName;
        private String secondName;
        private double grade;

        public Student(String firstName, String secondName, double grade) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.grade = grade;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getSecondName() {
            return secondName;
        }

        public double getGrade() {
            return grade;
        }

        @Override
        public String toString() {
            return  String.format("%s %s: %.2f",getFirstName(), getSecondName(), getGrade());
        }
    }
}
