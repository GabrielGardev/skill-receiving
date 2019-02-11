package P11_Threeuple;

public class Tuple<T, E, S> {
    private T item1;
    private E item2;
    private S item3;

    public Tuple(T item1, E item2, S item3) {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }

    public static boolean drunkOrNot(String drunkOrNot){
        if (drunkOrNot.equals("drunk")){
            return true;
        }
        return false;
    }

    public S getItem3() {
        return item3;
    }

    public void setItem3(S item3) {
        this.item3 = item3;
    }

    public T getItem1() {
        return item1;
    }

    public void setItem1(T item1) {
        this.item1 = item1;
    }

    public E getItem2() {
        return item2;
    }

    public void setItem2(E item2) {
        this.item2 = item2;
    }

    @Override
    public String toString() {
        return this.item1 + " -> " + this.item2 + " -> " + this.item3;
    }
}
