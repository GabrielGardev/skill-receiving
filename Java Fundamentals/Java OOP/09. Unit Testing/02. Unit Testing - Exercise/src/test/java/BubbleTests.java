import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p04_BubbleSortTest.Bubble;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BubbleTests {
    private int[] arr;
    private int[] expectedArr;

    @Before
    public void setUp() {
        this.arr = new int[]{6, 3, 2, 4, 1, 5};
        this.expectedArr = new int[]{1, 2, 3, 4, 5, 6};
    }

    @Test
    public void shouldSortCollection() {
        Bubble.sort(arr);

        assertArrayEquals(expectedArr, arr);
    }

    @Test
    public void shouldWorkingWithOnlyOneElementInCollection() {
        this.arr = new int[]{2};
        this.expectedArr = new int[]{2};

        assertArrayEquals(expectedArr, arr);
    }

    @Test
    public void shouldNotTouchSortedCollection() {
        this.arr = new int[]{1, 2, 3, 4, 5, 6};

        assertArrayEquals(expectedArr, arr);
    }
}
