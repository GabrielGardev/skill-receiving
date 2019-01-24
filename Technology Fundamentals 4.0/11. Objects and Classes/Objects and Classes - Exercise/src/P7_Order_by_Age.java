import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class P7_Order_by_Age {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();
        while (true){
            String [] line = scanner.nextLine().split(" ");
            if (line[0].equals("End")){
                break;
            }
            String name = line[0];
            String id = line[1];
            int age = Integer.parseInt(line[2]);

            Person person = new Person(name,id,age);
            people.add(person);
        }
        people.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .forEach(x -> System.out.println(x.toString()));
    }
    static class Person {
        private String name;
        private String id;
        private int age;

        public Person(String name, String id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return String.format("%s with ID: %s is %d years old.", getName(), getId(), getAge());
        }
    }
}
