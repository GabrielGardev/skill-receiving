import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {
    private BinarySearchTree<Integer> bst;


    @Before
    public void beforeEach(){
        bst = new BinarySearchTree<>(5);
        bst.insert(1);
        bst.insert(3);
        bst.insert(15);
        bst.insert(13);
        bst.insert(16);
        bst.insert(23);
    }


    @Test
    public void testCreate(){
        assertEquals(Integer.valueOf(5), bst.getRoot().getValue());
    }

    @Test
    public void testInsert(){
        assertEquals(Integer.valueOf(5), bst.getRoot().getValue());
        assertEquals(Integer.valueOf(1), bst.getRoot().getLeft().getValue());
        assertEquals(Integer.valueOf(3), bst.getRoot().getLeft().getRight().getValue());
        assertEquals(Integer.valueOf(15), bst.getRoot().getRight().getValue());
        assertEquals(Integer.valueOf(13), bst.getRoot().getRight().getLeft().getValue());
        assertEquals(Integer.valueOf(16), bst.getRoot().getRight().getRight().getValue());
        assertEquals(Integer.valueOf(23), bst.getRoot().getRight().getRight().getRight().getValue());
    }

    @Test
    public void testEachInOrder(){
        List<Integer> result = new ArrayList<>();
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 3, 5, 13, 15, 16, 23));

        bst.eachInOrder(result::add);

        assertEquals(expected, result);
    }

    @Test
    public void testContainsTrue(){
        assertTrue(bst.contains(1));
    }

    @Test
    public void testContainsFalse(){
        assertFalse(bst.contains(2));
    }

    @Test
    public void testSearchTrue(){
        BinarySearchTree<Integer> search = bst.search(15);

        bst.insert(8);

        assertEquals(Integer.valueOf(15), search.getRoot().getValue());
        assertEquals(Integer.valueOf(16), search.getRoot().getRight().getValue());
        assertEquals(Integer.valueOf(13), search.getRoot().getLeft().getValue());

        assertFalse(search.contains(8));
        assertTrue(bst.contains(8));
    }

    @Test
    public void testSearchFalse(){
        assertNull(bst.search(2));
    }

    @Test
    public void testInRange(){
        List<Integer> expected = new ArrayList<>(Arrays.asList(3, 5, 13, 15));
        List<Integer> actual = bst.range(3, 15);

        assertEquals(expected.size(), actual.size());
        for (Integer value : expected) {
            assertTrue(actual.contains(value));
        }
    }

    @Test
    public void testDeleteMin(){
        bst.deleteMin();
        assertFalse(bst.contains(1));
    }

    @Test
    public void testDeleteMax(){
        bst.deleteMax();
        assertFalse(bst.contains(23));
    }

    @Test
    public void testCount(){
        assertEquals(7, bst.count());
    }

    @Test
    public void testCountAfterInsert(){
        bst.insert(6);
        assertEquals(8, bst.count());
    }

    @Test
    public void testCountAfterDeleteMin(){
        bst.deleteMin();
        assertEquals(6, bst.count());
    }

    @Test
    public void testCountAfterDeleteMax(){
        bst.deleteMax();
        assertEquals(6, bst.count());
    }

    @Test
    public void testRank(){
        assertEquals(4, bst.rank(15));
    }

    @Test
    public void testRankMinElement(){
        assertEquals(0, bst.rank(-1));
    }

    @Test
    public void testRankEmptyTree(){
        assertEquals(0, new BinarySearchTree<Integer>().rank(1));
    }

    @Test
    public void testFloor(){
        assertEquals(Integer.valueOf(13), bst.floor(15));
    }

    @Test
    public void testEmptyFloor(){
        assertNull(bst.floor(-1));
    }

    @Test
    public void testCeil(){
        assertEquals(Integer.valueOf(16), bst.ceil(15));
    }

    @Test
    public void testEmptyCeil(){
        assertNull(bst.ceil(50));
    }
}