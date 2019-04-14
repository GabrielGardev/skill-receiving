import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p01_Database.Database;

import javax.naming.OperationNotSupportedException;

public class DatabaseTests {
    private static final Integer[] ELEMENTS = new Integer[]{1,2,3};

    private Database db;
    @Before
    public void initializeDatabase() throws OperationNotSupportedException {
        this.db = new Database(DatabaseTests.ELEMENTS);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void constructorShouldThrowExceptionIfElementsAreMoreThen16() throws OperationNotSupportedException {
        Database database = new Database(new Integer[17]);
    }

    @Test
    public void capacityShouldBeExactly16Integers() throws OperationNotSupportedException {
        Database database = new Database(new Integer[16]);
    }

    @Test
    public void methodAddShouldAddElementOnNextFreeCell() throws OperationNotSupportedException {
        int numberToAdd = 5;
        this.db.add(numberToAdd);

        Assert.assertEquals(numberToAdd, (int)this.db.getElements()[this.db.getElements().length - 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void methodAddShouldThrowExceptionIfElementIsNull() throws OperationNotSupportedException {
        this.db.add(null);
    }

    @Test
    public void removeShouldRemoveOnlyAtLastIndex() throws OperationNotSupportedException {
        int lastElement = this.db.getElements()[this.db.getElements().length - 1];

        this.db.remove();

        Assert.assertEquals(3, lastElement);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeShouldThrowExceptionIfRemoveFromEmptyCollection() throws OperationNotSupportedException {
        Database database = new Database(new Integer[1]);
        database.remove();
        database.remove();
    }

    @Test
    public void constructorShouldTakeIntegersAndStoreThemInArray(){
        Integer[] elements = this.db.getElements();

        Assert.assertEquals(Integer[].class, elements.getClass());
    }
}
