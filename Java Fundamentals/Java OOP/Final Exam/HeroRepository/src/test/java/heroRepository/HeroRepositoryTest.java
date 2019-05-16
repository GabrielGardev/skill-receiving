package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroRepositoryTest {
    private static final Item ITEM = new Item(10, 10, 10);
    private static final Item ITEM2 = new Item(20, 9, 20);
    private static final Item ITEM3 = new Item(3, 5, 30);
    private static final Item ITEM4 = new Item(-2, -6, -6);


    private static final Hero HERO = new Hero("Gosho", 5, ITEM);
    private static final Hero HERO2 = new Hero("Marto", 7, ITEM2);
    private static final Hero HERO3 = new Hero("Blagoi", 2, ITEM3);
    private static final Hero HERO4 = new Hero("Sasho", 6, ITEM4);

    private HeroRepository heroRepository;

    @Before
    public void setUp(){
        this.heroRepository = new HeroRepository();
    }

    @Test
    public void getCountShouldReturnCorrectCount(){
        this.heroRepository.add(HERO);
        this.heroRepository.add(HERO2);

        Assert.assertEquals(2, this.heroRepository.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addHeroShouldThrowExceptionIfHeroAlreadyExist(){
        this.heroRepository.add(HERO);
        this.heroRepository.add(HERO);
    }

    @Test
    public void addHeroShouldAddSuccessful(){
        this.heroRepository.add(HERO);

        Assert.assertEquals(1, this.heroRepository.getCount());
    }

    @Test
    public void addHeroShouldAddSuccessfull(){
        this.heroRepository.add(HERO);

        Assert.assertEquals(HERO, this.heroRepository.getHeroWithHighestAgility());
    }

    @Test(expected = NullPointerException.class)
    public void removeShouldThrowExceptionIfHeroDontExist(){
        this.heroRepository.add(HERO);
        this.heroRepository.remove("Pesho");
    }

    @Test
    public void removeShouldRemoveSuccessful(){
        this.heroRepository.add(HERO);
        this.heroRepository.add(HERO2);

        this.heroRepository.remove(HERO.getName());

        Assert.assertEquals(1, this.heroRepository.getCount());
    }

    @Test
    public void getHeroWithHighestStrengthShouldCorrectHero(){
        this.heroRepository.add(HERO);
        this.heroRepository.add(HERO2);
        this.heroRepository.add(HERO3);

        Assert.assertEquals(HERO2, this.heroRepository.getHeroWithHighestStrength());
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestStrengthShouldThrowExceptionIfNoHeroes(){

        this.heroRepository.getHeroWithHighestStrength();
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestStrengthShouldThrowExceptionIfStrengthIsNegative(){
        this.heroRepository.add(HERO4);

        this.heroRepository.getHeroWithHighestStrength();
    }
    @Test
    public void getHeroWithHighestAgilityShouldCorrectHero(){
        this.heroRepository.add(HERO);
        this.heroRepository.add(HERO2);
        this.heroRepository.add(HERO3);

        Assert.assertEquals(HERO, this.heroRepository.getHeroWithHighestAgility());
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestAgilityShouldThrowExceptionIfNoHeroes(){

        this.heroRepository.getHeroWithHighestAgility();
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestAgilityShouldThrowExceptionIfStrengthIsNegative(){
        this.heroRepository.add(HERO4);

        this.heroRepository.getHeroWithHighestAgility();
    }

    @Test
    public void getHeroWithHighestIntelligenceShouldCorrectHero(){
        this.heroRepository.add(HERO);
        this.heroRepository.add(HERO2);
        this.heroRepository.add(HERO3);

        Assert.assertEquals(HERO3, this.heroRepository.getHeroWithHighestIntelligence());
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestIntelligenceShouldThrowExceptionIfNoHeroes(){

        this.heroRepository.getHeroWithHighestIntelligence();
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestIntelligenceShouldThrowExceptionIfStrengthIsNegative(){
        this.heroRepository.add(HERO4);

        this.heroRepository.getHeroWithHighestIntelligence();
    }

    @Test
    public void constructorShouldCreatRepositoryCorrectly(){
        HeroRepository heroRepository2 = new HeroRepository();

        Assert.assertEquals(0, heroRepository2.getCount());
    }

}