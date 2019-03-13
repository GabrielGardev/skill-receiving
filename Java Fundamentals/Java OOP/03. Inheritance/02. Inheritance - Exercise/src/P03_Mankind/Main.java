package P03_Mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] line = reader.readLine().split("\\s+");

            String studentFirstName = line[0];
            String studentLastName = line[1];
            String facultyNumber = line[2];

            Student student = new Student(studentFirstName, studentLastName, facultyNumber);

            String[] workerLine = reader.readLine().split("\\s+");

            String workedFirstName = workerLine[0];
            String workedLastName = workerLine[1];
            double salary = Double.parseDouble(workerLine[2]);
            double workingHours = Double.valueOf(workerLine[3]);

            Worker worker = new Worker(workedFirstName, workedLastName, salary, workingHours);

            System.out.println(student.toString());
            System.out.println(worker.toString());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
