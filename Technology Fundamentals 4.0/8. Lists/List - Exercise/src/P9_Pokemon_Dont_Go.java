import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P9_Pokemon_Dont_Go {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pokemons = Arrays
                .stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int sumOfRemovedElements = 0;


        while (!pokemons.isEmpty()) {
            int index = Integer.parseInt(scanner.nextLine());
            int currentRemovedElement = 0;

            if (index < 0) {
                sumOfRemovedElements += pokemons.get(0);
                currentRemovedElement = pokemons.get(0);
                pokemons.remove(0);
                pokemons.add(0, pokemons.get(pokemons.size() - 1));
            } else if (index > pokemons.size() - 1) {
                sumOfRemovedElements += pokemons.get(pokemons.size() - 1);
                currentRemovedElement = pokemons.get(pokemons.size() - 1);
                pokemons.remove(pokemons.size() - 1);
                pokemons.add(pokemons.get(0));
            } else {
                sumOfRemovedElements += pokemons.get(index);
                currentRemovedElement = pokemons.get(index);
                pokemons.remove(index);
            }


            for (int i = 0; i < pokemons.size(); i++) {
                if (pokemons.get(i) > currentRemovedElement) {
                    pokemons.set(i, pokemons.get(i) - currentRemovedElement);
                } else {
                    pokemons.set(i, pokemons.get(i) + currentRemovedElement);
                }
            }
        }
        System.out.println(sumOfRemovedElements);
    }
}
