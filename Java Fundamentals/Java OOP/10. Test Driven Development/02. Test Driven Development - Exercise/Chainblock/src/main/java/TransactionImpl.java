public class TransactionImpl implements Transaction{

    private int id;
    private TransactionStatus status;
    private String from;
    private String to;
    private double amount;

    public TransactionImpl(int id, TransactionStatus status, String from, String to, double amount) {
        this.id = id;
        this.status = status;
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public String getReceiver() {
        return to;
    }

    @Override
    public String getSender() {
        return from;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public int compareTo(Transaction o) {
        return Integer.compare(this.id, o.getId());
    }

    @Override
    public void setSender(String sender) {
        this.from = sender;
    }

    @Override
    public void setReceiver(String receiver) {
        this.to = receiver;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.status = transactionStatus;
    }

    @Override
    public TransactionStatus getTransactionStatus() {
        return this.status;
    }
}
