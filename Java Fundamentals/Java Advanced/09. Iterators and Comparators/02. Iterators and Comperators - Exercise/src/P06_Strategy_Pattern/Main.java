package P06_Strategy_Pattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeSet<Person> peopleByNames = new TreeSet<>(new CompareByName());
        TreeSet<Person> peopleByAge = new TreeSet<>(new CompareByAge());

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(" ");
            Person person = new Person(line[0], Integer.parseInt(line[1]));
            peopleByNames.add(person);
            peopleByAge.add(person);
        }
        for (Person person : peopleByNames) {
            System.out.println(person.toString());
        }

        for (Person person : peopleByAge) {
            System.out.println(person.toString());
        }
    }
}
