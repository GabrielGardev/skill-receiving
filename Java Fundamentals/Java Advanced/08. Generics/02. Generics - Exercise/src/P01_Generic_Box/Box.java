package P01_Generic_Box;

public class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.getClass().getName() + ": " + value;
    }

    public T getValue() {
        return value;
    }
}
