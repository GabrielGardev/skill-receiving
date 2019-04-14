package hell;

import hell.entities.heroes.Assassin;
import hell.entities.heroes.Barbarian;
import hell.entities.heroes.Wizard;
import hell.entities.items.CommonItem;
import hell.entities.items.RecipeItem;
import hell.interfaces.Hero;
import hell.interfaces.Item;
import hell.interfaces.Manager;
import hell.interfaces.Recipe;

import java.util.*;
import java.util.stream.Collectors;

public class ManagerImpl implements Manager {
    private Map<String, Hero> heroes;

    public ManagerImpl() {
        this.heroes = new HashMap<>();
    }

    @Override
    public String addHero(List<String> arguments) {
        String name = arguments.get(1);
        String type = arguments.get(2);

        Hero hero = createHero(name, type);
        this.heroes.put(name, hero);
        return String.format("Created %s – %s", type, name);
    }

    @Override
    public String addItem(List<String> arguments) {
        String name = arguments.get(1);
        String heroName = arguments.get(2);
        int strengthBonus = Integer.parseInt(arguments.get(3));
        int agilityBonus = Integer.parseInt(arguments.get(4));
        int intelligenceBonus = Integer.parseInt(arguments.get(5));
        int hitPointsBonus = Integer.parseInt(arguments.get(6));
        int damageBonus = Integer.parseInt(arguments.get(7));

        Item item = new CommonItem(name,
                strengthBonus,
                agilityBonus,
                intelligenceBonus,
                hitPointsBonus,
                damageBonus);
        this.heroes.get(heroName).addItem(item);

        return String.format("Added item - %s to Hero - %s", name, heroName);
    }

    @Override
    public String addRecipe(List<String> arguments) {
        String name = arguments.get(1);
        String heroName = arguments.get(2);
        int strengthBonus = Integer.parseInt(arguments.get(3));
        int agilityBonus = Integer.parseInt(arguments.get(4));
        int intelligenceBonus = Integer.parseInt(arguments.get(5));
        int hitPointsBonus = Integer.parseInt(arguments.get(6));
        int damageBonus = Integer.parseInt(arguments.get(7));
        List<String> requiredItems = arguments.stream().skip(8).collect(Collectors.toList());

        Recipe recipe = new RecipeItem(name,
                strengthBonus,
                agilityBonus,
                intelligenceBonus,
                hitPointsBonus,
                damageBonus,
                requiredItems);

        this.heroes.get(heroName).addRecipe(recipe);
        return String.format("Added recipe - %s to Hero – %s", name, heroName);
    }

    @Override
    public String inspect(List<String> arguments) {
        String heroName = arguments.get(1);

        return this.heroes.get(heroName).toString();
    }

    @Override
    public String quit() {
        List<Hero> sorted = this.heroes.values()
                .stream()
                .sorted((a, b) -> {
                    long aSum = a.getStrength() + a.getAgility() + a.getIntelligence();
                    long bSum = b.getStrength() + b.getAgility() + b.getIntelligence();

                    int result = Long.compare(bSum, aSum);

                    if (result == 0) {
                        aSum = a.getHitPoints() + a.getDamage();
                        bSum = b.getHitPoints() + b.getDamage();
                        result = Long.compare(bSum, aSum);
                    }

                    return result;
                }).collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        int index = 1;
        String separator = System.lineSeparator();

        for (Hero hero : sorted) {
            List<String> result = new ArrayList<>();

            if (hero.getItems().isEmpty()){
                result.add("None");
            }else {
                for (Item item : hero.getItems()) {
                    result.add(item.getName());
                }
            }

            sb.append(index++)
                    .append(". ")
                    .append(hero.getClass().getSimpleName())
                    .append(": ")
                    .append(hero.getName())
                    .append(separator)
                    .append("###HitPoints: ")
                    .append(hero.getHitPoints())
                    .append(separator)
                    .append("###Damage: ")
                    .append(hero.getDamage())
                    .append(separator)
                    .append("###Strength: ")
                    .append(hero.getStrength())
                    .append(separator)
                    .append("###Agility: ")
                    .append(hero.getAgility())
                    .append(separator)
                    .append("###Intelligence: ")
                    .append(hero.getIntelligence())
                    .append(separator)
                    .append("###Items: ")
                    .append(String.join(", ", result))
                    .append(separator);
        }
        return sb.toString();
    }

    private Hero createHero(String name ,String type) {
        Hero hero = null;

        switch (type){
            case "Barbarian":
                hero = new Barbarian(name);
                break;
            case "Assassin":
                hero = new Assassin(name);
                break;
            case "Wizard":
                hero = new Wizard(name);
                break;
        }
        return hero;
    }
}
