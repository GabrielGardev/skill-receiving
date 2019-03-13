package P06_Animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String type = reader.readLine();

        while (!type.equals("Beast!")) {
            String[] line = reader.readLine().split("\\s+");
            String name = line[0];
            int age = Integer.parseInt(line[1]);
            String gender = line[2];

            try {
                switch (type) {
                    case "Animal":
                        Animal animal = new Animal(name, age, gender);
                        System.out.println(type);
                        System.out.println(animal.toString());
                        System.out.println(animal.produceSound());
                        break;
                    case "Dog":
                        Dog dog = new Dog(name, age, gender);
                        System.out.println(type);
                        System.out.println(dog.toString());
                        System.out.println(dog.produceSound());
                        break;
                    case "Cat":
                        Cat cat = new Cat(name, age, gender);
                        System.out.println(type);
                        System.out.println(cat.toString());
                        System.out.println(cat.produceSound());
                        break;
                    case "Frog":
                        Frog frog = new Frog(name, age, gender);
                        System.out.println(type);
                        System.out.println(frog.toString());
                        System.out.println(frog.produceSound());
                        break;
                    case "Tomcat":
                        Tomcat tomcat = new Tomcat(name, age, gender);
                        System.out.println(type);
                        System.out.println(tomcat.toString());
                        System.out.println(tomcat.produceSound());
                        break;
                    case "Kitten":
                        Kitten kitten = new Kitten(name, age, gender);
                        System.out.println(type);
                        System.out.println(kitten.toString());
                        System.out.println(kitten.produceSound());
                        break;
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }


            type = reader.readLine();
        }
    }
}
