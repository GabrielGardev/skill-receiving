import java.util.*;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock{
    private Map<Integer,Transaction> data;

    public ChainblockImpl() {
        this.data = new LinkedHashMap<>();
    }

    public int getCount() {
        return this.data.size();
    }

    public void add(Transaction transaction) {
        this.data.put(transaction.getId(), transaction);
    }

    public boolean contains(Transaction transaction) {
        return this.contains(transaction.getId());
    }

    public boolean contains(int id) {
        return this.data.containsKey(id);
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        this.getById(id).setTransactionStatus(newStatus);
    }

    public void removeTransactionById(int id) {
        if (!this.contains(id)){
            throw new IllegalArgumentException();
        }
        this.data.remove(id);
    }

    public Transaction getById(int id) {
        if (!this.contains(id)){
            throw new IllegalArgumentException();
        }
        return this.data.get(id);
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> list = this.data.values()
                .stream()
                .filter(t -> t.getTransactionStatus().equals(status))
                .sorted((a, b) -> Double.compare(b.getAmount(), a.getAmount()))
                .collect(Collectors.toList());

        if (list.isEmpty()){
            throw new IllegalArgumentException();
        }
        return list;
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        List<String> list = this.data.values()
                .stream()
                .filter(t -> t.getTransactionStatus().equals(status))
                .sorted((a, b) -> Double.compare(b.getAmount(), a.getAmount()))
                .map(Transaction::getSender)
                .collect(Collectors.toList());

        if (list.isEmpty()){
            throw new IllegalArgumentException();
        }
        return list;
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        List<String> list = this.data.values()
                .stream()
                .sorted((a, b) -> Double.compare(b.getAmount(), a.getAmount()))
                .filter(t -> t.getTransactionStatus().equals(status))
                .map(Transaction::getReceiver)
                .collect(Collectors.toList());

        if (list.isEmpty()){
            throw new IllegalArgumentException();
        }
        return list;
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return this.data.values()
                .stream()
                .sorted((a, b) -> new SortedByAmountThenById().compare(a, b))
                .collect(Collectors.toList());

    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        List<Transaction> transactions = this.data.values()
                .stream()
                .filter(x -> x.getSender().equals(sender))
                .sorted((a, b) -> Double.compare(b.getAmount(), a.getAmount()))
                .collect(Collectors.toUnmodifiableList());

        if (transactions.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return transactions;
    }


    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        List<Transaction> transactions = this.data.values()
                .stream()
                .filter(x -> x.getReceiver().equals(receiver))
                .sorted((a, b) -> new SortedByAmountThenById().compare(a, b))
                .collect(Collectors.toUnmodifiableList());

        if (transactions.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return transactions;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        return this.data.values()
                .stream()
                .filter(x -> x.getTransactionStatus().equals(status) && x.getAmount() <= amount)
                .sorted((a, b) -> Double.compare(b.getAmount(), a.getAmount()))
                .collect(Collectors.toUnmodifiableList());
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        List<Transaction> transactions = this.data.values().stream()
                .filter(x -> x.getSender().equals(sender) && x.getAmount() > amount)
                .sorted((a, b) -> Double.compare(b.getAmount(), a.getAmount()))
                .collect(Collectors.toUnmodifiableList());

        if (transactions.isEmpty()) {

            throw new IllegalArgumentException();
        }

        return transactions;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        List<Transaction> transactions = this.data.values().stream()
                .filter(x -> x.getReceiver().equals(receiver) && x.getAmount() >= lo && x.getAmount() < hi)
                .sorted((a, b) -> Double.compare(b.getAmount(), a.getAmount()))
                .collect(Collectors.toUnmodifiableList());

        if (transactions.isEmpty()) {

            throw new IllegalArgumentException();
        }

        return transactions;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return this.data.values().stream()
                .filter(x -> x.getAmount() >= lo && x.getAmount() <= hi)
                .collect(Collectors.toUnmodifiableList());
    }

    public Iterator<Transaction> iterator() {
        return this.data.values().iterator();
    }
}
