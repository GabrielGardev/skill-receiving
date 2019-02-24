package P05_Comparing_Objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> people = new ArrayList<>();
        while (true){
            String[] line = reader.readLine().split(" ");
            if (line[0].equals("END")){
                break;
            }
            Person person = new Person(line[0], Integer.parseInt(line[1]), line[2]);
            people.add(person);
        }
        int n = Integer.parseInt(reader.readLine());
        Person myMan = people.get(n - 1);

        long equalPeoples = people.stream().filter(p -> p.compareTo(myMan) == 0).count();

        if (equalPeoples > 1){
            System.out.printf("%d %d %d", equalPeoples, people.size() - equalPeoples, people.size());
        }else {
            System.out.println("No matches");
        }
    }
}
