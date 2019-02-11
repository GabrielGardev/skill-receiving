package P06_Generic_Count_Method_Doubles;

public class Box<T extends Comparable>  {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.value.getClass().getName() + ": " + this.value;
    }

}
