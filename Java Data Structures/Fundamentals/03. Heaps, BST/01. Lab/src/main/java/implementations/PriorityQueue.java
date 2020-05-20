package implementations;

import interfaces.AbstractQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PriorityQueue<E extends Comparable<E>> implements AbstractQueue<E> {
    private List<E> elements;

    public PriorityQueue() {
        this.elements = new ArrayList<>();
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public void add(E element) {
        elements.add(element);
        heapifyUp(size() - 1);
    }

    @Override
    public E peek() {
        ensureNonEmpty();
        return getAt(0);
    }

    @Override
    public E poll() {
        ensureNonEmpty();
        E returnedValue = getAt(0);
        Collections.swap(this.elements, 0 , size() - 1);
        elements.remove(size() - 1);
        heapifyDown(0);
        return returnedValue;
    }

    private void heapifyDown(int index) {
        while (index < size() / 2){
            int child = 2 * index + 1;

            if (child + 1 < size() && isLess(child, child + 1)){
                child = child + 1;
            }

            if (isLess(child, index)){
                break;
            }

            Collections.swap(elements, index, child);
            index = child;
        }
    }

    private void heapifyUp(int index) {
        while (index > 0 && isLess(getParentIndex(index), index)) {
            int parentIndex = getParentIndex(index);
            Collections.swap(elements, index, parentIndex);
            index = parentIndex;
        }
    }

    private boolean isLess(int first, int second) {
        return getAt(first).compareTo(getAt(second)) < 0;
    }

    private E getAt(int index) {
        return elements.get(index);
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }


    private void ensureNonEmpty() {
        if (size() == 0) {
            throw new IllegalStateException("Heap is empty upon peek/pool attempt");
        }
    }
}
