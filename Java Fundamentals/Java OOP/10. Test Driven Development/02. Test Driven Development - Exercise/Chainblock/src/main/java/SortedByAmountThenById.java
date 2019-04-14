import java.util.Comparator;

public class SortedByAmountThenById implements Comparator<Transaction> {

    @Override
    public int compare(Transaction a, Transaction b) {
        int compare = Double.compare(b.getAmount(), a.getAmount());

        if (compare == 0) {
            compare = a.compareTo(b);
        }
        return compare;
    }
}
