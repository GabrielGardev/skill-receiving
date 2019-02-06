package P06_Pokemon_Trainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Trainer> trainers = new LinkedHashMap<>();

        while (true){
            String[] line = reader.readLine().split("\\s+");
            if (line[0].equals("Tournament")){
                break;
            }
            String trainerName = line[0];
            String pokemonName = line[1];
            String element = line[2];
            int health = Integer.parseInt(line[3]);

            Pokemon pokemon = new Pokemon(pokemonName, element, health);
            ArrayList<Pokemon> pokemon1 = new ArrayList<>();
            pokemon1.add(pokemon);

            if (!trainers.containsKey(trainerName)){
                Trainer trainer = new Trainer(trainerName, pokemon1);

                trainers.put(trainerName, trainer);
            }else {
                trainers.get(trainerName).getPokemons().add(pokemon);
            }

        }

        while (true){
            String element = reader.readLine();
            if (element.equals("End")){
                break;
            }
            for (var trainer : trainers.entrySet()) {
                boolean containElement = false;

                for (Pokemon pokemon : trainer.getValue().getPokemons()) {
                    if (pokemon.getElement().equals(element)){
                        containElement = true;
                        trainer.getValue().setNumberOfBadges(1);
                        break;
                    }
                }
                if (!containElement){
                    for (Pokemon pokemon : trainer.getValue().getPokemons()) {
                        pokemon.setHealth(10);
                    }
                    if (!trainer.getValue().getPokemons().isEmpty()) {
                        trainer.getValue().getPokemons().removeIf(pokemon -> pokemon.getHealth() <= 0);
                    }
                }
            }
        }

        trainers.entrySet().stream().sorted((a, b) -> Integer.compare(b.getValue().getNumberOfBadges(), a.getValue().getNumberOfBadges()))
                .forEach(trainer -> System.out.println(String.format("%s %d %d",trainer.getKey(),
                        trainer.getValue().getNumberOfBadges(), trainer.getValue().getPokemons().size())));
    }
}
