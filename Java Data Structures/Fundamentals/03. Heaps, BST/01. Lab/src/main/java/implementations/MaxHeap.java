package implementations;

import interfaces.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxHeap<E extends Comparable<E>> implements Heap<E> {
    private List<E> elements;

    public MaxHeap() {
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
        if (size() == 0){
            throw new IllegalStateException("Heap is empty upon peek attempt");
        }
        return getAt(0);
    }

    private void heapifyUp(int index) {
        while (index > 0 && isLess(index, getParentIndex(index))){
            int parentIndex = getParentIndex(index);
            Collections.swap(elements, index, parentIndex);
            index = parentIndex;
        }
    }

    private boolean isLess(int childIndex, int parentIndex) {
        return getAt(childIndex).compareTo(getAt(parentIndex)) > 0;
    }

    private E getAt(int index){
        return elements.get(index);
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }
}
