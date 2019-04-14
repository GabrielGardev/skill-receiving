import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import p03_IteratorTest.ListIterator;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Field;

public class ListIteratorTests {
    private static final String[] ELEMENTS = new String[]{"peshaka", "goshaka", "mitaka"};

    private ListIterator listIterator;
    private ListIterator mocked;

    @Before
    public void initialize() throws OperationNotSupportedException {
        this.listIterator = new ListIterator(ListIteratorTests.ELEMENTS);
        this.mocked = Mockito.mock(ListIterator.class);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void constructorShouldThrowExceptionIfElementsAreNull() throws OperationNotSupportedException {
        this.listIterator = new ListIterator((String[]) null);
    }

    @Test
    public void moveShouldMoveOnNextIndexPosition(){
        boolean move = this.listIterator.move();

        Assert.assertTrue(move);
    }

    @Test
    public void moveShouldReturnFalseIfThereIsNoNextIndex(){
        Mockito.when(this.mocked.hasNext()).thenReturn(false);

        Assert.assertFalse(this.mocked.move());
    }

    @Test
    public void hasNextShouldReturnTrueIfThereIsANextIndex(){
        Assert.assertTrue(this.listIterator.hasNext());
    }

    @Test
    public void hasNextShouldReturnFalseIfThereIsNoNextIndex() throws NoSuchFieldException, IllegalAccessException {
        Field currentIndex = this.listIterator.getClass().getDeclaredField("currentIndex");
        currentIndex.setAccessible(true);

        currentIndex.setInt(this.listIterator, 2);

        Assert.assertFalse(this.listIterator.hasNext());
    }

    @Test
    public void printShouldReturnElementAtCurrentIndex(){
        String result = this.listIterator.print();

        Assert.assertEquals(ListIteratorTests.ELEMENTS[0], result);
    }

    @Test(expected = IllegalStateException.class)
    public void printShouldThrowExceptionOnCollectionWithoutElements() throws OperationNotSupportedException {
        this.listIterator = new ListIterator();

        this.listIterator.print();
    }
}
