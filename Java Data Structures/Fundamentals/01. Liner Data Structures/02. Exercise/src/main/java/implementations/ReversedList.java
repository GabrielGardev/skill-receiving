package implementations;


import interfaces.ReversedListInter;

import java.util.Arrays;
import java.util.Iterator;

public class ReversedList<E> implements ReversedListInter<E> {
    private final int DEFAULT_CAPACITY = 2;
    private Object[] elements;
    private int size;
    private int capacity;

    public ReversedList() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.capacity = DEFAULT_CAPACITY;
    }

    @Override
    public void add(E element) {
        ensureCapacity();
        this.elements[this.size++] = element;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int capacity() {
        return this.capacity;
    }

    @Override
    public E get(int index) {
        validateIndex(index);
        int indexToReturn = (this.size - 1) - index;

        return this.getElement(indexToReturn);
    }

    @Override
    public E removeAt(int index) {
        validateIndex(index);

        E element = this.get(index);
        int indexToRemove = (this.size - 1) - index;

        shiftLeft(indexToRemove);
        this.size--;

        if (this.size <= this.capacity / 4
                && this.capacity > DEFAULT_CAPACITY) {
            resize();
        }

        return element;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int currentIndex = size - 1;

            @Override
            public boolean hasNext() {
                return currentIndex >= 0;
            }

            @Override
            public E next() {
                return getElement(currentIndex--);
            }
        };
    }

    private void ensureCapacity() {
        if (this.size >= this.capacity) {
            grow();
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

    @SuppressWarnings("unchecked")
    private E getElement(int index) {
        return (E) this.elements[index];
    }

    private void shiftLeft(int index) {
        for (int i = index; i < this.size - 1; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.elements[this.size - 1] = null;
    }

    private void resize() {

        if (this.size <= this.capacity / 4) {
            this.capacity /= 2;
        } else if (this.size >= this.capacity) {
            this.capacity *= 2;
        }

        E[] newArray = (E[]) new Object[this.capacity];
        System.arraycopy(elements, 0,
                newArray, 0, this.size);

        this.elements = newArray;
    }
}
