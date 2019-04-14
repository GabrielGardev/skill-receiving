package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class AxeTests {
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int DUMMY_HEALTH = 20;
    private static final int DUMMY_XP = 10;
    private static final int EXPECTED_DURABILITY = AXE_DURABILITY - 1;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void initializeTestObjects() {
        this.axe = new Axe(AxeTests.AXE_ATTACK, AxeTests.AXE_DURABILITY);
        this.dummy = new Dummy(AxeTests.DUMMY_HEALTH, AxeTests.DUMMY_XP);
    }

    @Test
    public void weaponAttackLosesDurability() {
        this.axe.attack(dummy);

        Assert.assertEquals(AxeTests.EXPECTED_DURABILITY, this.axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void brokenWeaponCantAttack() {
        Axe axe = new Axe(AxeTests.AXE_ATTACK, 1);

        axe.attack(this.dummy);
        axe.attack(this.dummy);
    }
}
