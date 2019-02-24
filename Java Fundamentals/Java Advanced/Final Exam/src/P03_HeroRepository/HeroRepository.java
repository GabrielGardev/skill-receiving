package P03_HeroRepository;

import java.util.HashMap;
import java.util.Map;

public class HeroRepository {
    private Map<String , Hero> repository;

    public HeroRepository() {
        this.repository = new HashMap<>();
    }

    public void add(Hero hero){
        this.repository.put(hero.getName(), hero);
    }

    public void remove(String name){
        this.repository.remove(name);
    }

    public Hero getHeroWithHighestStrength(){
        int maxStr = Integer.MIN_VALUE;
        Hero chosenHero = new Hero();
        for (var hero : this.repository.entrySet()) {
            Integer strength = hero.getValue().getItem().getStrength();

            if (strength > maxStr){
                maxStr = strength;
                chosenHero = hero.getValue();
            }
        }
        return chosenHero;
    }

    public Hero getHeroWithHighestAgility() {
        int maxAgility = Integer.MIN_VALUE;
        Hero chosenHero = new Hero();
        for (var hero : this.repository.entrySet()) {
            Integer agility = hero.getValue().getItem().getAgility();

            if (agility > maxAgility){
                maxAgility = agility;
                chosenHero = hero.getValue();
            }
        }
        return chosenHero;
    }

    public Hero getHeroWithHighestIntelligence() {
        int maxIntel = Integer.MIN_VALUE;
        Hero chosenHero = new Hero();
        for (var hero : this.repository.entrySet()) {
            Integer Intelligence = hero.getValue().getItem().getIntelligence();

            if (Intelligence > maxIntel){
                maxIntel = Intelligence;
                chosenHero = hero.getValue();
            }
        }
        return chosenHero;
    }

    public int getCount(){
      return this.repository.size();
    }

    @Override
    public String toString() {
        final String[] result = {""};
        this.repository.values().forEach(h -> result[0] += h.toString());
        return result[0];
    }
}
