package P08_Family_Tree;

import java.awt.event.PaintEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Person> people = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> commands = new ArrayList<>();
        String mainPersonInfo = reader.readLine();

        while (true){
            String command = reader.readLine();
            if (command.equals("End")){
                break;
            }

            if (!command.contains("-")){
                Person person = new Person();

                String [] humanFullInfo = command.split(" ");
                String name = humanFullInfo[0] + " " + humanFullInfo[1];
                String birthDate = humanFullInfo[2];

                person.setName(name);
                person.setBirthDate(birthDate);

                people.add(person);
            }else {
                commands.add(command);
            }
        }

        Person mainPerson = findByNameOrDate(mainPersonInfo);

        for (String command : commands) {
            String [] tokens = command.split(" - ");

            Person firstHuman = findByNameOrDate(tokens[0]);
            Person secondHuman = findByNameOrDate(tokens[1]);

            if (firstHuman.getName().equals(mainPerson.getName())){
                mainPerson.getChildren().add(secondHuman);
            }else if (secondHuman.getName().equals(mainPerson.getName())){
                mainPerson.getParents().add(firstHuman);
            }
        }
        System.out.println(mainPerson.toString());
        System.out.println("Parents:");
        mainPerson.getParents().forEach(System.out::println);
        System.out.println("Children:");
        mainPerson.getChildren().forEach(System.out::println);

    }

    private static Person findByNameOrDate(String token) {
        return people
                .stream()
                .filter(p -> p.getName().equals(token) || p.getBirthDate().equals(token))
                .findFirst()
                .get();
    }

}
