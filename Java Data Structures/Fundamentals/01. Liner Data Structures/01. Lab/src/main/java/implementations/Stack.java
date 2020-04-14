package implementations;

import interfaces.AbstractStack;

import java.util.Iterator;

public class Stack<E> implements AbstractStack<E> {
    private Node<E> top;
    private int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    private static class Node<E>{
        private E element;
        private Node<E> previous;

        public Node(E element) {
            this.element = element;
            this.previous = null;
        }
    }

    @Override
    public void push(E element) {
        Node<E> newNode = new Node<>(element);
        newNode.previous = top;
        this.top = newNode;
        this.size++;
    }

    @Override
    public E pop() {
        ensureNotEmpty();

        E element = this.top.element;
        Node<E> newTop = this.top.previous;
        this.top.previous = null;

        this.top = newTop;
        this.size--;
        return element;
    }

    @Override
    public E peek() {
        ensureNotEmpty();

        return this.top.element;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = top;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E element = current.element;
                this.current = current.previous;
                return element;
            }
        };
    }

    private void ensureNotEmpty() {
        if (this.size < 1){
            throw new IllegalStateException("The stack is empty!");
        }
    }
}
