package P01_Opinion_Poll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");
            Person person = new Person(line[0], Integer.parseInt(line[1]));

            if (person.getAge() > 30){
                people.add(person);
            }
        }
        people.stream()
                .sorted(Comparator.comparing(Person::getName))
                .forEach(x -> System.out.printf("%s - %d%n", x.getName(), x.getAge()));

    }
}
