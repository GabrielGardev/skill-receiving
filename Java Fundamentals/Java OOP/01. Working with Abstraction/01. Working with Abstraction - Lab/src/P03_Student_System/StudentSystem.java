package P03_Student_System;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repo;

    public StudentSystem() {
        this.repo = new HashMap<>();
    }

    public Map<String, Student> getRepo() {
        return this.repo;
    }

    public void ParseCommand(String[] args) {

        if (args[0].equals("Create")) {
            this.createStudent(args);
        } else if (args[0].equals("Show")) {
            this.showStudent(args[1]);
        }
    }

    private void showStudent(String name) {
        if (!repo.containsKey(name)) {
            return;
        }
        Student student = this.repo.get(name);
        System.out.println(student.toString());
    }

    private void createStudent(String[] args) {
        String name = args[1];
        int age = Integer.parseInt(args[2]);
        double grade = Double.parseDouble(args[3]);

        if (repo.containsKey(name)) {
           return;
        }

        Student student = new Student(name, age, grade);
        repo.put(name,student);
    }
}
