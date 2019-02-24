package P07_Equality_Logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeSet<Person> people = new TreeSet<>();
        HashSet<Person> people1 = new HashSet<>();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split("\\s+");
            Person person = new Person(line[0], Integer.parseInt(line[1]));
            people.add(person);
            people1.add(person);
        }
        System.out.println(people.size());
        System.out.println(people1.size());
    }
}
