package rpg_tests;

import fakes.FakeAxe;
import fakes.FakeTarget;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.Hero;
import rpg_lab.Target;
import rpg_lab.Weapon;

public class HeroTests {
    private static final String HERO_NAME = "Name";

    @Test
    public void attackGainsEXIfTargetIsDead(){
        Target targetMock = Mockito.mock(Target.class);
        Weapon weaponMock = Mockito.mock(Weapon.class);
        Mockito.when(targetMock.isDead()).thenReturn(true);
        Mockito.when(targetMock.giveExperience()).thenReturn(10);

        Hero hero = new Hero(HERO_NAME, weaponMock);
        hero.attack(targetMock);
        Assert.assertEquals("Wrong experience", 10, hero.getExperience());
    }

    @Test
    public void shouldGetLootWhenTargetDies(){
        Weapon weaponMock = Mockito.mock(Weapon.class);
        Target targetMock = Mockito.mock(Target.class);

        Hero hero = new Hero(HERO_NAME, weaponMock);
        Mockito.when(targetMock.isDead()).thenReturn(true);
        Mockito.when(targetMock.getPossibleWeapon()).thenReturn(weaponMock);

        hero.attack(targetMock);

        Assert.assertEquals(weaponMock, hero.getInventory().get(0));


    }
}
