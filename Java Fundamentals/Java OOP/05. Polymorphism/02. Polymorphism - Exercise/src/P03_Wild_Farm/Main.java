package P03_Wild_Farm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Animal> animals = new ArrayList<>();
        while (true) {
            String[] animalInfo = reader.readLine().split("\\s+");
            if (animalInfo[0].equals("End")) {
                break;
            }
            String[] foodInfo = reader.readLine().split("\\s+");

            String type = animalInfo[0];
            String name = animalInfo[1];
            double weight = Double.parseDouble(animalInfo[2]);
            String home = animalInfo[3];

            Animal animal = null;

            switch (type) {
                case "Cat":
                    String breed = animalInfo[4];
                    animal = new Cat(name, type, weight, home, breed);
                    break;
                case "Mouse":
                    animal = new Mouse(name, type, weight, home);
                    break;
                case "Tiger":
                    animal = new Tiger(name, type, weight, home);
                    break;
                case "Zebra":
                    animal = new Zebra(name, type, weight, home);
                    break;
            }

            Food food = null;
            if (foodInfo[0].equals("Vegetable")) {
                food = new Vegetable(Integer.parseInt(foodInfo[1]));
            } else {
                food = new Meat(Integer.parseInt(foodInfo[1]));
            }

            animal.makeSound();
            animal.eat(food);
            animals.add(animal);
        }
        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }
}
