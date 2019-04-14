package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class DummyTests {
    private static final int DUMMY_ATTACK = 5;
    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_XP = 10;

    private Dummy dummy;


    @Before
    public void initializeTestObjects(){
        this.dummy = new Dummy(DummyTests.DUMMY_HEALTH, DummyTests.DUMMY_XP);
    }

    @Test
    public void shouldLoseHealthIfAttacked() {
        this.dummy.takeAttack(DummyTests.DUMMY_ATTACK);

        Assert.assertEquals(5, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void DeadDummyShouldThrowExceptionIfAttacked(){
        Dummy dummy = new Dummy(-DummyTests.DUMMY_HEALTH, DummyTests.DUMMY_XP);

        dummy.takeAttack(DummyTests.DUMMY_ATTACK);
    }

    @Test
    public void DeadDummyShouldGiveXP(){
        Dummy mocked = Mockito.mock(Dummy.class);
        Mockito.when(mocked.giveExperience()).thenReturn(DUMMY_XP);

        int experience = dummy.giveExperience();

        Assert.assertEquals(DummyTests.DUMMY_XP, experience);
    }

    @Test(expected = IllegalStateException.class)
    public void AliveDummyCantGiveXP(){

        int experience = this.dummy.giveExperience();
    }
}
