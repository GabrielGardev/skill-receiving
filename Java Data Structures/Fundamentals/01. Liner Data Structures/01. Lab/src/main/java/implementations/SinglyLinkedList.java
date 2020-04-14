package implementations;

import interfaces.LinkedList;

import java.util.Iterator;

public class SinglyLinkedList<E> implements LinkedList<E> {
    private Node<E> head;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element) {
            this.element = element;
            this.next = null;
        }
    }

    @Override
    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element);

        newNode.next = this.head;
        this.head = newNode;

        this.size++;
    }

    @Override
    public void addLast(E element) {
        Node<E> newNode = new Node<>(element);

        if (this.isEmpty()) {
            this.head = newNode;
        } else {
            Node<E> current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        this.size++;
    }

    @Override
    public E removeFirst() {
        ensureNotEmpty();
        E element = this.head.element;

        if (this.size == 1){
            this.head = null;
        }else {
            Node<E> next = this.head.next;
            this.head.next = null;
            this.head = next;
        }
        this.size--;
        return element;
    }

    @Override
    public E removeLast() {
        ensureNotEmpty();
        E element;

        if (this.size == 1){
            element = this.head.element;
            this.head = null;
        }else {
            Node<E> prev = this.head;
            Node<E> toRemove = this.head.next;

            while (toRemove.next != null) {
                prev = toRemove;
                toRemove = toRemove.next;
            }
            element = toRemove.element;
            prev.next = null;
        }
        this.size--;
        return element;
    }

    @Override
    public E getFirst() {
        ensureNotEmpty();
        return this.head.element;
    }

    @Override
    public E getLast() {
        Node<E> current = this.head;
        while (current.next != null) {
            current = current.next;
        }

        return current.element;
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
            private Node<E> current = head;
            @Override
            public boolean hasNext() {
                return this.current != null;
            }

            @Override
            public E next() {
                E element = this.current.element;
                this.current = this.current.next;
                return element;
            }
        };
    }

    private void ensureNotEmpty() {
        if (this.isEmpty()){
            throw new IllegalStateException("The list is empty!");
        }
    }
}
