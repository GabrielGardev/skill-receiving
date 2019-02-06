package P07_Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Person> people = new HashMap<>();

        while (true) {
            String[] line = reader.readLine().split("\\s+");
            if (line[0].equals("End")) {
                break;
            }

            String personName = line[0];
            String cmd = line[1];
            Person person = null;
            if (!people.containsKey(personName)) {
                person = new Person(personName);
            } else {
                person = people.get(personName);
            }

            switch (cmd) {
                case "company":
                    String companyName = line[2];
                    String department = line[3];
                    double salary = Double.parseDouble(line[4]);

                    Company company = new Company(companyName, department, salary);
                    person.setCompany(company);
                    break;

                case "pokemon":
                    String pokeName = line[2];
                    String type = line[3];

                    Pokemon pokemon = new Pokemon(pokeName, type);
                    //RISK
                    people.getOrDefault(personName, person).getPokemons().add(pokemon);
                    break;

                case "parents":
                    String parentName = line[2];
                    String parentBirthday = line[3];

                    Parent parent = new Parent(parentName, parentBirthday);
                    //RISK
                    people.getOrDefault(personName, person).getParents().add(parent);
                    break;

                case "children":
                    String childName = line[2];
                    String childBirthday = line[3];

                    Children children = new Children(childName, childBirthday);
                    //RISK
                    people.getOrDefault(personName, person).getChildren().add(children);
                    break;

                case "car":
                    String model = line[2];
                    int speed = Integer.parseInt(line[3]);

                    Car car = new Car(model, speed);
                    person.setCar(car);
                    break;
            }
            people.put(personName, person);
        }
        String nameToPrint = reader.readLine();

        System.out.println(nameToPrint);

        System.out.println("Company:");
        if (people.get(nameToPrint).getCompany() != null) {
            System.out.println(people.get(nameToPrint).getCompany().toString());
        }

        System.out.println("Car:");
        if (people.get(nameToPrint).getCar() != null){
            System.out.println(people.get(nameToPrint).getCar().toString());
        }

        System.out.println("Pokemon:");
        if (!people.get(nameToPrint).getPokemons().isEmpty()){
            for (Pokemon pokemon : people.get(nameToPrint).getPokemons()) {
                System.out.println(pokemon.toString());
            }
        }

        System.out.println("Parents:");
        if (!people.get(nameToPrint).getParents().isEmpty()){
            for (Parent parent : people.get(nameToPrint).getParents()) {
                System.out.println(parent.toString());
            }
        }

        System.out.println("Children:");
        if (!people.get(nameToPrint).getChildren().isEmpty()){
            for (Children child : people.get(nameToPrint).getChildren()) {
                System.out.println(child.toString());
            }
        }
    }
}
