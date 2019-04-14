import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p05_CustomLinkedList.CustomLinkedList;

import java.lang.reflect.Field;

public class CustomLinkedListTests {

    private CustomLinkedList<Integer> list;

    @Before
    public void setUp() {
        this.list = new CustomLinkedList<>();
    }

    @Test
    public void shouldHaveZeroCountWhenCreated() throws NoSuchFieldException, IllegalAccessException {

        Field countField = list.getClass().getDeclaredField("count");
        countField.setAccessible(true);
        int count = (int) countField.get(list);

        Assert.assertEquals(count, 0);
    }

    @Test
    public void shouldIncreaseCountWhenAdding() throws IllegalAccessException, NoSuchFieldException {

        list.add(10);
        Field countField = list.getClass().getDeclaredField("count");
        countField.setAccessible(true);
        int count = (int) countField.get(list);

        Assert.assertEquals(count, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenTryGetWithIndexGreaterOrEqualToElementsLength() {
        list.get(0);
    }

    @Test
    public void shouldReturnElementAtGivenValidIndex() {

        for (int i = 0; i < 5; i++) {
            list.add(i);
        }

        int element = list.get(4);
        Assert.assertEquals(element, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenRemoveAtInvalidIndex() {
        this.list.removeAt(0);
    }

    @Test
    public void shouldRemoveCorrectlyAtValidIndex() {

        for (int i = 0; i < 5; i++) {
            list.add(i);
        }

        Integer nextValue = list.get(3);

        list.removeAt(2);

        Integer shiftedValue = list.get(2);

        Assert.assertEquals(shiftedValue, nextValue);
    }


    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenTrySetElementAtInvalidIndex() {
        list.set(0, 10);
    }

    @Test
    public void shouldSetCorrectlyWithValidIndex() {

        list.add(10);

        list.set(0, 9);

        Assert.assertEquals(list.get(0), Integer.valueOf(9));

    }


    @Test
    public void shouldGiveIndexOfValidItem() {
        list.add(10);
        int index = list.indexOf(10);
        Assert.assertEquals(index, 0);
    }

    @Test
    public void shouldReturnNegativeValueWhenTryGetIndexOfInvalidItem() {

        int index = list.indexOf(10);

        Assert.assertEquals(index, -1);
    }

    @Test
    public void shouldReturnTrueInContainsWithValidElement() {
        list.add(10);

        boolean contains = list.contains(10);

        Assert.assertTrue(contains);
    }


    @Test
    public void shouldReturnFalseInContainsWithInvalidElement() {

        boolean contains = list.contains(10);

        Assert.assertFalse(contains);

    }

    @Test
    public void shouldRemoveExistingElement() {

        list.add(10);

        list.remove(10);

        boolean contains = list.contains(10);

        Assert.assertFalse(contains);
    }

    @Test
    public void shouldReturnNegativeValueWhenRemovingSomethingThatDoesNotExist() {

        int value = list.remove(10);

        Assert.assertEquals(value, -1);
    }
}
