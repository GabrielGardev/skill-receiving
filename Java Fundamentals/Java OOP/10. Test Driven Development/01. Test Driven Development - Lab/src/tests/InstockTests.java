import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class InstockTests {
    private static final Product FIRST_PRODUCT = new Product("Coca-cola", 1.50, 3);
    private static final Product SECOND_PRODUCT = new Product("Banana", 0.50, 5);
    private static final Product THIRD_PRODUCT = new Product("Hell", 1.00, 4);

    public Instock stock;

    @Before
    public void setUp(){
        this.stock = new Instock();
        stock.add(FIRST_PRODUCT);
        stock.add(SECOND_PRODUCT);
        stock.add(THIRD_PRODUCT);
    }

    @Test
    public void shouldCheckIfProductIsInStockAfterAddMethod(){
        assertTrue(stock.contains(FIRST_PRODUCT));
    }

    @Test
    public void shouldReturnCountOfTheProducts(){
        assertEquals(3, stock.getCount());
    }

    @Test
    public void shouldReturnNthProductInStock(){
        assertEquals(SECOND_PRODUCT, stock.find(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionIfIndexIsOutOfBounds(){
      stock.find(5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void changeQuantityThrowExceptionIfTheProductIsNotInStock(){
      stock.changeQuantity("Coca-Cola", 5);
    }

    @Test
    public void changeQuantityOfTheGivenProduct(){
        int expected = FIRST_PRODUCT.getQuantity() + 5;
        stock.changeQuantity(FIRST_PRODUCT.getLabel(), 5);

        assertEquals(expected,
                stock.findByLabel(FIRST_PRODUCT.getLabel()).getQuantity());
    }

    @Test
    public void findByLabelShouldReturnProductOfTheGivenProductName(){
        assertEquals(SECOND_PRODUCT, stock.findByLabel(SECOND_PRODUCT.getLabel()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByLabelShouldThrowExceptionIfProductIsNotPresent(){
        stock.findByLabel("Pesho");
    }

    @Test
    public void findFirstByAlphabeticalOrderShouldReturnEmptyCollectionIfCountIsOutOfRange(){
        Iterable<Product> actual = this.stock.findFirstByAlphabeticalOrder(5);

        assertFalse(actual.iterator().hasNext());
    }

    @Test
    public void findFirstByAlphabeticalOrderShouldReturnSortedCollection(){
        ArrayList<Product> actual = (ArrayList<Product>) stock.findFirstByAlphabeticalOrder(2);
        List<Product> expected = new ArrayList<>();
        expected.add(SECOND_PRODUCT);
        expected.add(FIRST_PRODUCT);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnDescendingOrderedCollectionInRange(){
        List<Product> actual = (List<Product>) stock.findAllInRange(0.49, 1.70);

        List<Product> expected = new ArrayList<>();
        expected.add(SECOND_PRODUCT);
        expected.add(THIRD_PRODUCT);
        expected.add(FIRST_PRODUCT);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyCollectionIfThereIsNotSuchProducts(){
        List<Product> actual = (List<Product>) stock.findAllInRange(80.49, 90.70);

        assertTrue(actual.isEmpty());
    }

    @Test
    public void shouldReturnCollectionOfProductsWithGivenPrice(){
        List<Product> actual = (List<Product>) stock.findAllByPrice(SECOND_PRODUCT.getPrice());

        List<Product> expected = new ArrayList<>();
        expected.add(SECOND_PRODUCT);

        assertEquals(expected, actual);
    }

    @Test
    public void findAllByPriceShouldReturnEmptyCollectionIfThereIsNotSuchProducts(){
        List<Product> actual = (List<Product>) stock
                .findAllByPrice(60.60);

        assertTrue(actual.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void findFirstMostExpensiveProductsShouldReturnExceptionIfCountIsBiggerThenCollectionSize(){
        List<Product> actual = (List<Product>) stock
                .findFirstMostExpensiveProducts(60);
    }

    @Test
    public void findFirstNMostExpensiveProducts(){
        List<Product> actual = (List<Product>) stock
                .findFirstMostExpensiveProducts(2);

        List<Product> expected = new ArrayList<>();
        expected.add(FIRST_PRODUCT);
        expected.add(THIRD_PRODUCT);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnCollectionOfProductsWithGivenQuantity(){
        List<Product> actual = (List<Product>) stock.findAllByQuantity(SECOND_PRODUCT.getQuantity());

        List<Product> expected = new ArrayList<>();
        expected.add(SECOND_PRODUCT);

        assertEquals(expected, actual);
    }

    @Test
    public void findAllByQuantityShouldReturnEmptyCollectionIfThereIsNotSuchProducts(){
        List<Product> actual = (List<Product>) stock
                .findAllByQuantity(70);

        assertTrue(actual.isEmpty());
    }

    @Test
    public void iteratorShouldReturnAllProducts(){
        Iterator<Product> iterator = stock.iterator();

        List<Product> expected = new ArrayList<>();
        while (iterator.hasNext()){
            expected.add(iterator.next());
        }

        assertEquals(stock.getCount(), expected.size());
    }
}
