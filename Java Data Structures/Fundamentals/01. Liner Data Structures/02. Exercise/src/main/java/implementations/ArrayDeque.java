package implementations;

import interfaces.Deque;

import java.util.Iterator;

public class ArrayDeque<E> implements Deque<E> {
    private final int DEFAULT_CAPACITY = 7;

    private Object[] elements;
    private int middle;
    private int head;
    private int tail;
    private int size;

    public ArrayDeque() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.middle = this.elements.length / 2;
        this.head = this.tail = this.middle;
        this.size = 0;
    }

    @Override
    public void add(E element) {
        if (this.size == 0){
            this.elements[this.tail] = element;
        }else {
            if (this.tail == this.elements.length - 1){
                this.elements = grow();
            }
            this.elements[++this.tail] = element;
        }
        this.size++;
    }

    @Override
    public void offer(E element) {
        add(element);
    }

    @Override
    public void addFirst(E element) {
        if (this.size == 0){
            add(element);
        }else {
            if (this.head == 0){
                this.elements = grow();
            }
            this.elements[--this.head] = element;
            this.size++;
        }
    }

    @Override
    public void addLast(E element) {
        add(element);
    }

    @Override
    public void push(E element) {
        addFirst(element);
    }

    @Override
    public void insert(int index, E element) {
        int realIndex = this.head + index;
        ensureIndex(realIndex);

        if (realIndex - this.head < this.tail - realIndex){
            insertAndShiftLeft(realIndex - 1, element);
        }else {
            insertAndShiftRight(realIndex, element);
        }
    }

    @Override
    public void set(int index, E element) {
        int realIndex = this.head + index;
        ensureIndex(realIndex);

        this.elements[realIndex] = element;
    }

    @Override
    public E peek() {
        if (this.size != 0){
            return getElement(this.head);
        }
        return null;
    }

    @Override
    public E poll() {
        return removeFirst();
    }

    @Override
    public E pop() {
        return removeLast();
    }

    @Override
    public E get(int index) {
        int realIndex = this.head + index;
        ensureIndex(realIndex);
        return getElement(realIndex);
    }

    @Override
    public E get(Object object) {
        if (isEmpty()){
            return null;
        }

        for (int i = this.head; i <= this.tail; i++) {
            if (getElement(i).equals(object)){
                return getElement(i);
            }
        }
        return null;
    }

    @Override
    public E remove(int index) {
        int realIndex = this.head + index;
        ensureIndex(realIndex);

        E element = getElement(realIndex);
        removeAndShiftLeft(realIndex);

        return element;
    }

    @Override
    public E remove(Object object) {
        if (isEmpty()){
            return null;
        }
        for (int i = this.head; i <= this.tail; i++) {
            if (getElement(i).equals(object)){
                E element = getElement(i);
                removeAndShiftLeft(i);
                return element;
            }
        }
        return null;
    }

    @Override
    public E removeFirst() {
        if (!isEmpty()){
            E element = this.getElement(this.head);
            this.elements[this.head++] = null;
            this.size--;
            return element;
        }
        return null;
    }

    @Override
    public E removeLast() {
        if (!isEmpty()){
            E element = getElement(this.tail);
            this.elements[this.tail--] = null;
            this.size--;
            return element;
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int capacity() {
        return this.elements.length;
    }

    @Override
    public void trimToSize() {
        Object[] newElements = new Object[this.size];
        int index = 0;
        for (int i = this.head; i <= this.tail; i++) {
            newElements[index++] = this.elements[i];
        }
        this.elements = newElements;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int currentIndex = head;
            @Override
            public boolean hasNext() {
                return currentIndex <= tail;
            }

            @Override
            public E next() {
                return getElement(currentIndex++);
            }
        };
    }

    private Object[] grow() {
        int newSize = this.elements.length * 2 + 1;

        Object[] newElements = new Object[newSize];
        int middle = newSize / 2;
        int begin = middle - this.size / 2;

        int index = this.head;

        for (int i = begin; index <= this.tail ; i++) {
            newElements[i] = this.elements[index++];
        }
        this.head = begin;
        this.tail = this.head + this.size - 1;
        return newElements;
    }

    @SuppressWarnings("unchecked")
    private E getElement(int index){
        return (E) this.elements[index];
    }

    private void ensureIndex(int realIndex) {
        if (realIndex < this.head || realIndex > this.tail){
            throw new IndexOutOfBoundsException();
        }
    }

    private void insertAndShiftRight(int index, E element) {
        E lastElement = getElement(this.tail);
        for (int i = this.tail; i > index; i--) {
            this.elements[i] = this.elements[i - 1];
        }
        this.elements[index] = element;
        this.add(lastElement);
    }

    private void insertAndShiftLeft(int index, E element) {
        E firstElement = getElement(this.head);
        for (int i = this.head; i < index; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.elements[index] = element;
        this.addFirst(firstElement);
    }

    private void removeAndShiftLeft(int realIndex) {
        this.elements[realIndex] = null;
        for (int i = realIndex; i < this.tail; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        removeLast();
    }
}
