package implementations;

import interfaces.List;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E> implements List<E> {
    private static final int INITIAL_CAPACITY = 4;
    private Object[] elements;
    private int size;
    private int capacity;

    public ArrayList() {
        this.elements = new Object[INITIAL_CAPACITY];
        this.size = 0;
        this.capacity = INITIAL_CAPACITY;
    }

    @Override
    public boolean add(E element) {
        ensureCapacity();
        this.elements[this.size++] = element;
        return true;
    }

    @Override
    public boolean add(int index, E element) {
        validateIndex(index);
        insert(index, element);
        return true;
    }

    @Override
    public E get(int index) {
        validateIndex(index);
        return this.getElement(index);
    }

    @Override
    public E set(int index, E element) {
        validateIndex(index);
        E prevValue = this.getElement(index);
        this.elements[index] = element;

        return prevValue;
    }

    @Override
    public E remove(int index) {
        validateIndex(index);
        E prevValue = this.getElement(index);

        shiftLeft(index);
        this.size--;
        shrink();

        return prevValue;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int indexOf(E element) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(E element) {
        return this.indexOf(element) != -1;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return this.index < size();
            }

            @Override
            public E next() {
                return get(index++);
            }
        };
    }

    private void ensureCapacity() {
        if (this.size == this.capacity) {
            grow();
        }
    }

    private void shrink() {
        if(this.size < this.capacity / 3){
            this.capacity /= 2;
            this.elements = Arrays.copyOf(this.elements, this.capacity);
        }
    }

    private void grow() {
        this.capacity *= 2;
        this.elements = Arrays.copyOf(this.elements, this.capacity);
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Wrong index!");
        }
    }

    private void insert(int index, E element) {
        ensureCapacity();

        for (int i = this.size; i > index; i--) {
            this.elements[i] = this.elements[i - 1];
        }
        this.elements[index] = element;
        this.size++;
    }

    private void shiftLeft(int index) {
        for (int i = index; i < this.size - 1; i++) {
            this.elements[i] = this.elements[i + 1];
        }
    }

    private E getElement(int index) {
        return (E) this.elements[index];
    }

}
