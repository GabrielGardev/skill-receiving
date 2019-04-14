import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p02_ExtendedDatabase.Database;
import p02_ExtendedDatabase.Person;

import javax.naming.OperationNotSupportedException;

public class ExtendedDatabaseTests {
    private static final int INIT_PERSONS_COUNT = 3;
    private static final int NOT_PRESENT_ID = 4;

    private Person person;
    private Database database;

    @Before
    public void initialize() throws OperationNotSupportedException {
        this.person = new Person(5, "Gosho");
        this.database = new Database(new Person[ExtendedDatabaseTests.INIT_PERSONS_COUNT]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addShouldThrowExceptionIfPersonIsNull() throws OperationNotSupportedException {
        Person pesho = null;
        this.database.add(pesho);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameShouldThrowExceptionIfUsernameNotPresent() throws OperationNotSupportedException {
        this.database.findByUsername("Petaka");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameShouldThrowExceptionIfUsernameIsNull() throws OperationNotSupportedException {
        this.database.findByUsername(null);
    }

    @Test
    public void findByUsernameShouldHaveCaseSensitiveArguments() throws OperationNotSupportedException {
        this.database.add(this.person);

        String expectedName = "gosho";
        Person person = this.database.findByUsername(this.person.getUsername());

        Assert.assertNotEquals(expectedName, person.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByIdShouldThrowExceptionIfIdNotPresent() throws OperationNotSupportedException {
        this.database.findById(ExtendedDatabaseTests.NOT_PRESENT_ID);
    }
}
