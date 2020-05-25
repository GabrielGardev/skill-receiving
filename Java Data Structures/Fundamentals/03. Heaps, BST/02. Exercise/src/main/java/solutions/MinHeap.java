package solutions;

import interfaces.Decrease;
import interfaces.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinHeap<E extends Comparable<E> & Decrease<E>> implements Heap<E> {
    private List<E> data;

    public MinHeap() {
        this.data = new ArrayList<>();
    }

    @Override
    public int size() {
        return this.data.size();
    }

    @Override
    public void add(E element) {
        this.data.add(element);
        heapifyUp();
    }

    @Override
    public E peek() {
        ensureNonEmpty();
        return this.data.get(0);
    }

    @Override
    public E poll() {
        ensureNonEmpty();
        Collections.swap(this.data, 0 , getSize() - 1);
        E removed = this.data.remove(getSize() - 1);
        heapifyDown();
        return removed;
    }

    @Override
    public void decrease(E element) {

    }

    private int getSize(){
        return this.data.size();
    }

    private void heapifyUp() {
        int index = getSize() - 1;
        int parentIndex = getParentIndexFrom(index);

        while (index > 0 && isLess(index, parentIndex)){
            Collections.swap(this.data, index, parentIndex);
            index = parentIndex;
            parentIndex = getParentIndexFrom(index);
        }
    }

    private void heapifyDown() {
        int index = 0;
        int swapIndex = getLeftChildIndex(index);

        while (swapIndex < getSize() - 1){
            int rightChildIndex = getRightChildIndex(index);

            if (rightChildIndex < getSize() - 1){
                swapIndex = isLess(swapIndex, rightChildIndex) ? swapIndex : rightChildIndex;
            }

            if (isLess(index, swapIndex)){
                break;
            }

            Collections.swap(this.data, index, swapIndex);
            index = swapIndex;
            swapIndex = getLeftChildIndex(index);
        }
    }

    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    private boolean isLess(int firstIndex, int secondIndex) {
        return data.get(firstIndex).compareTo(data.get(secondIndex)) < 0;
    }

    private int getParentIndexFrom(int index) {
        return (index - 1) / 2;
    }

    private void ensureNonEmpty() {
        if (this.data.isEmpty()){
            throw new IllegalStateException();
        }
    }
}
