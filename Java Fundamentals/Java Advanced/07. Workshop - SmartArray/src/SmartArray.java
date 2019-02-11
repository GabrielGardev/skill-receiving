import java.util.Arrays;
import java.util.function.Consumer;

public class SmartArray {
    private static final int INITIAL_CAPACITY = 4;

    private int[] data;
    private int size;
    private int capacity;

    public SmartArray() {
        this.data = new int[INITIAL_CAPACITY];
        this.capacity = INITIAL_CAPACITY;
    }

    public void add(int element){
        if (this.size == this.capacity){
            this.grow();
        }
        this.data[this.size] = element;
        this.size++;
    }

    private void grow() {
        this.capacity *= 2;
        int[] newData = new int[this.capacity];

        for (int i = 0; i < this.data.length; i++) {
            newData[i] = this.data[i];
        }
        this.data = newData;
    }

    public int removeAt(int index){
        if (index < 0 || index > this.size - 1){
            throw new IndexOutOfBoundsException("Index out of bounds for SmartArray with size of " + this.size);
        }

        int deletedElement = this.data[index];

        this.shift(index);
        this.size--;
        if (this.size <= this.capacity / 4) {
            this.shrink();
        }

        return deletedElement;
    }

    public void insert(int index, int element){
        if (index < 0 || index > this.size - 1){
            throw new IndexOutOfBoundsException("Index out of bounds for SmartArray with size of " + this.size);
        }

        if (index == this.size - 1){
            this.add(this.data[this.size - 1]);
            this.data[this.size - 2] = element;
        }else {
            this.size++;
            if (this.size >= capacity){
                this.grow();
            }
            this.shiftRight(index);
            this.data[index] = element;
        }
    }

    public boolean contains(int element){
       return Arrays.stream(this.data)
                .anyMatch(e -> e == element);
    }

    public void forEach(Consumer<Integer> consumer){
        int size = this.size;
        int i = 0;
        while (size-- > 0){
            consumer.accept(this.data[i++]);
        }
    }

    public int get(int index){
        if (index < 0 || index > this.size - 1){
            throw new IndexOutOfBoundsException("Index out of bounds for SmartArray with size of " + this.size);
        }

        return this.data[index];
    }

    private void shiftRight(int index) {
        for (int i = this.size - 1; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }
    }

    private void shrink() {
        this.capacity /= 2;
        int[] newData = new int[this.capacity];

        for (int i = 0; i < newData.length; i++) {
            newData[i] = this.data[i];
        }

        this.data = newData;
    }

    private void shift(int index) {
        for (int i = index; i < this.size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
        this.data[size - 1] = 0;
    }
}
