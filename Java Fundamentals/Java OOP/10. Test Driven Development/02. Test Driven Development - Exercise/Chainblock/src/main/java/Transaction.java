public interface Transaction {
    int getId();
    void setTransactionStatus(TransactionStatus transactionStatus);
    TransactionStatus getTransactionStatus();
    double getAmount();
    String getSender();
    String getReceiver();
    int compareTo(Transaction transaction);
    void setSender(String sender);
    void setReceiver(String receiver);
}
