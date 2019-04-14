import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class ChainBlockTests {
    private static final Transaction TRANSACTION_ONE = new TransactionImpl(1, TransactionStatus.SUCCESSFUL,
            "Pesho", "Gosho", 15.56);
    private static final Transaction TRANSACTION_TWO = new TransactionImpl(2, TransactionStatus.ABORTED,
            "Racho", "Marin", 14.67);
    private static final Transaction TRANSACTION_THREE = new TransactionImpl(3, TransactionStatus.FAILED,
            "Ivo", "Gabo", 13.28);
    private static final Transaction TRANSACTION_FOUR = new TransactionImpl
            (4, TransactionStatus.SUCCESSFUL, "Hell", "MIAMI", 70);

    private static final Transaction TRANSACTION_FIVE = new TransactionImpl
            (5, TransactionStatus.SUCCESSFUL, "Heaven", "MIAMI", 69);


    private ChainblockImpl chainblock;

    @Before
    public void setUp() {
        this.chainblock = new ChainblockImpl(){{
            add(TRANSACTION_ONE);
            add(TRANSACTION_TWO);
            add(TRANSACTION_THREE);
        }};
    }

    @Test
    public void shouldAddTransaction() {
        Assert.assertTrue(chainblock.contains(TRANSACTION_THREE));
    }

    @Test
    public void transactionShouldPresentById() {
        Assert.assertTrue(chainblock.contains(TRANSACTION_THREE.getId()));
    }

    @Test
    public void shouldReturnNumberOfTransactionInTheRecord() {
        Assert.assertEquals(3, this.chainblock.getCount());
    }

    @Test
    public void shouldChangeTransactionStatus() {
        this.chainblock.changeTransactionStatus(2, TransactionStatus.UNAUTHORIZED);
        Assert.assertEquals(TransactionStatus.UNAUTHORIZED, this.chainblock.getById(2).getTransactionStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void changeTransactionStatusShouldThrowExceptionIfTransactionNotExist() {
        this.chainblock.changeTransactionStatus(8, TransactionStatus.UNAUTHORIZED);
    }

    @Test
    public void shouldRemoveTransactionById() {
        this.chainblock.removeTransactionById(2);
        Assert.assertEquals(2, this.chainblock.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeByIdShouldThrowExceptionIfTransactionNotExist() {
        this.chainblock.removeTransactionById(8);
    }

    @Test
    public void shouldTransactionById() {
        Assert.assertEquals(TRANSACTION_ONE, this.chainblock.getById(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfTransactionByIdDoNotPresent() {
        this.chainblock.getById(8);
    }

    @Test
    public void shouldReturnCollectionOfTransactionsByStatus() {
        List<Transaction> transactions = (List<Transaction>) this.chainblock
                .getByTransactionStatus(TransactionStatus.ABORTED);

        Assert.assertEquals(1, transactions.size());
    }

    @Test
    public void shouldReturnCollectionOfTransactionsByStatusOrderedByDescending() {
        List<Transaction> transactions = (List<Transaction>) this.chainblock
                .getByTransactionStatus(TransactionStatus.SUCCESSFUL);

        Assert.assertEquals(TRANSACTION_ONE, transactions.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfThereIsNoTransactionWithGivenStatus() {
        List<Transaction> transactions = (List<Transaction>) this.chainblock
                .getByTransactionStatus(TransactionStatus.UNAUTHORIZED);
    }

    @Test
    public void shouldReturnCollectionOfSendersByStatus() {
        List<String> list = (List<String>) this.chainblock
                .getAllSendersWithTransactionStatus(TransactionStatus.ABORTED);

        Assert.assertEquals(1, list.size());
    }

    @Test
    public void shouldReturnCollectionOfSendersByStatusOrderedByDescending() {
        List<String> list = (List<String>) this.chainblock
                .getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);

        Assert.assertEquals(TRANSACTION_ONE.getSender(), list.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfThereIsNoSenderWithGivenStatus() {

        List<String> list= (List<String>) this.chainblock
                .getAllSendersWithTransactionStatus(TransactionStatus.UNAUTHORIZED);
    }

    @Test
    public void shouldReturnCollectionOfReceiversByStatus() {
        List<String> list = (List<String>) this.chainblock
                .getAllReceiversWithTransactionStatus(TransactionStatus.ABORTED);

        Assert.assertEquals(1, list.size());
    }

    @Test
    public void shouldReturnCollectionOfReceiversByStatusOrderedByDescending() {
        List<String> list = (List<String>) this.chainblock
                .getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL);

        Assert.assertEquals(TRANSACTION_ONE.getReceiver(), list.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfThereIsNoReceiverWithGivenStatus() {
        List<String> list= (List<String>) this.chainblock
                .getAllReceiversWithTransactionStatus(TransactionStatus.UNAUTHORIZED);
    }

    @Test
    public void shouldReturnAllTransactionsSortedByAmountThenById() {
        List<Transaction> list = (List<Transaction>) this.chainblock
                .getAllOrderedByAmountDescendingThenById();

        Assert.assertEquals(TRANSACTION_THREE, list.get(list.size() - 1));
    }

    @Test
    public void shouldReturnTransactionsBySender() {
        List<Transaction> list = (List<Transaction>) this.chainblock
                .getBySenderOrderedByAmountDescending(TRANSACTION_ONE.getSender());

        Assert.assertEquals(TRANSACTION_ONE, list.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfThereIsNoSuchSender() {
        List<Transaction> list= (List<Transaction>) this.chainblock
                .getBySenderOrderedByAmountDescending("Panaiot");
    }

    @Test
    public void shouldReturnAllTransactionsBySenderSortedByAmount() {
        TRANSACTION_FIVE.setSender(TRANSACTION_THREE.getSender());
        this.chainblock.add(TRANSACTION_FIVE);

        List<Transaction> list = (List<Transaction>) this.chainblock
                .getBySenderOrderedByAmountDescending(TRANSACTION_THREE.getSender());

        Assert.assertEquals(TRANSACTION_FIVE, list.get(0));
    }

    @Test
    public void shouldReturnTransactionsByReceiver() {
        List<Transaction> list = (List<Transaction>) this.chainblock
                .getByReceiverOrderedByAmountThenById(TRANSACTION_ONE.getReceiver());

        Assert.assertEquals(TRANSACTION_ONE, list.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfThereIsNoSuchReceiver() {
        List<Transaction> list= (List<Transaction>) this.chainblock
                .getByReceiverOrderedByAmountThenById("Panaiot");
    }

    @Test
    public void shouldReturnAllTransactionsByReceiverSortedByAmountThenById() {
        TRANSACTION_FIVE.setReceiver(TRANSACTION_THREE.getReceiver());
        this.chainblock.add(TRANSACTION_FIVE);

        List<Transaction> list = (List<Transaction>) this.chainblock
                .getByReceiverOrderedByAmountThenById(TRANSACTION_THREE.getReceiver());

        Assert.assertEquals(TRANSACTION_FIVE, list.get(0));
    }

    @Test
    public void shouldReturnTransactionsByStatusAndMaximumAmount() {
        List<Transaction> list = (List<Transaction>) this.chainblock
                .getByTransactionStatusAndMaximumAmount(
                        TRANSACTION_ONE.getTransactionStatus(),
                        16);

        Assert.assertEquals(TRANSACTION_ONE, list.get(0));
    }

    @Test
    public void shouldEmptyCollectionIfNoSuchStatusExistOrAmountIsOverTheMaximum() {
        List<Transaction> list= (List<Transaction>) this.chainblock
                .getByTransactionStatusAndMaximumAmount(
                        TRANSACTION_ONE.getTransactionStatus(),
                        2);
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void shouldReturnTransactionsByStatusAndMaximumAmountByDescending() {
        this.chainblock.add(TRANSACTION_FIVE);

        List<Transaction> list = (List<Transaction>) this.chainblock
                .getByTransactionStatusAndMaximumAmount(
                        TRANSACTION_ONE.getTransactionStatus(),
                        TRANSACTION_FIVE.getAmount() + 1);

        Assert.assertEquals(TRANSACTION_FIVE, list.get(0));
    }

    @Test
    public void shouldReturnTransactionsBySenderAndMinimumAmount() {
        List<Transaction> list = (List<Transaction>) this.chainblock
                .getBySenderAndMinimumAmountDescending(
                        TRANSACTION_ONE.getSender(),
                        1);

        Assert.assertEquals(TRANSACTION_ONE, list.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnExeptionIfNoSuchSenderExistOrAmountIsUnderTheMinimum() {
        List<Transaction> list= (List<Transaction>) this.chainblock
                .getBySenderAndMinimumAmountDescending(
                        "Panaiot",
                        2);
    }

    @Test
    public void shouldReturnTransactionsBySenderAndMinimumAmountByDescending() {
        TRANSACTION_FIVE.setSender(TRANSACTION_ONE.getSender());
        this.chainblock.add(TRANSACTION_FIVE);

        List<Transaction> list = (List<Transaction>) this.chainblock
                .getBySenderAndMinimumAmountDescending(
                        TRANSACTION_ONE.getSender(),
                        10);

        Assert.assertEquals(TRANSACTION_FIVE, list.get(0));
    }

    @Test
    public void shouldReturnTransactionsByReceiverAndAmountRange() {
        List<Transaction> list = (List<Transaction>) this.chainblock
                .getByReceiverAndAmountRange(
                        TRANSACTION_ONE.getReceiver(),
                        1,
                        20);

        Assert.assertEquals(TRANSACTION_ONE, list.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfThereIsNoSuchReceiverOrAmountIsOutOfRange() {
        List<Transaction> list= (List<Transaction>) this.chainblock
                .getByReceiverAndAmountRange(
                        "Panaiot",
                        2,
                        5);
    }

    @Test
    public void shouldReturnTransactionsByReciverAndAmountRangeByDescending() {
        TRANSACTION_FIVE.setReceiver(TRANSACTION_ONE.getReceiver());
        this.chainblock.add(TRANSACTION_FIVE);

        List<Transaction> list = (List<Transaction>) this.chainblock
                .getByReceiverAndAmountRange(
                        TRANSACTION_ONE.getReceiver(),
                        10,
                        100);

        Assert.assertEquals(TRANSACTION_FIVE, list.get(0));
    }

    @Test
    public void shouldReturnTransactionsInAmountRange() {
        List<Transaction> list = (List<Transaction>) this.chainblock
                .getAllInAmountRange(
                        1,
                        15);

        Assert.assertEquals(2, list.size());
    }

    @Test
    public void shouldReturnEmptyCollectionIfAmountIsOutOfRange() {
        List<Transaction> list= (List<Transaction>) this.chainblock
                .getAllInAmountRange(
                        2,
                        5);
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void shouldReturnTransactionsInGivenRangeInInsertionOrder() {
        this.chainblock.add(TRANSACTION_FIVE);

        List<Transaction> list = (List<Transaction>) this.chainblock
                .getAllInAmountRange(
                        10,
                        100);

        Assert.assertEquals(TRANSACTION_ONE, list.get(0));
    }

}
