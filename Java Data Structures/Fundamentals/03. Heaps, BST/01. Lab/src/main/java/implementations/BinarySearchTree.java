package implementations;

import interfaces.AbstractBinarySearchTree;

public class BinarySearchTree<E extends Comparable<E>> implements AbstractBinarySearchTree<E> {
    private Node<E> root;
    private Node<E> leftChild;
    private Node<E> rightChild;

    public BinarySearchTree() {

    }

    public BinarySearchTree(Node<E> element){
        copy(element);
    }

    @Override
    public void insert(E element) {
        Node<E> newNode = new Node<>(element);
        if (getRoot() == null) {
            root = newNode;
        } else {
            Node<E> currentRoot = getRoot();
            Node<E> prev = null;

            while (currentRoot != null) {
                prev = currentRoot;
                if (isLess(element, currentRoot.value)) {
                    currentRoot = currentRoot.leftChild;
                } else if (isGreater(element, currentRoot.value)) {
                    currentRoot = currentRoot.rightChild;
                } else {
                    return;
                }
            }

            assert prev != null;
            if (isLess(element, prev.value)) {
                prev.leftChild = newNode;
            } else if (isGreater(element, prev.value)) {
                prev.rightChild = newNode;
            }
        }
    }

    @Override
    public boolean contains(E element) {
        Node<E> currentRoot = getRoot();

        while (currentRoot != null) {
            if (isLess(element, currentRoot.value)) {
                currentRoot = currentRoot.leftChild;
            } else if (isGreater(element, currentRoot.value)) {
                currentRoot = currentRoot.rightChild;
            } else {
                return true;
            }
        }
        return false;
    }

    @Override
    public AbstractBinarySearchTree<E> search(E element) {
        AbstractBinarySearchTree<E> result = new BinarySearchTree<>();

        Node<E> currentRoot = getRoot();

        while (currentRoot != null) {
            if (isLess(element, currentRoot.value)) {
                currentRoot = currentRoot.leftChild;
            } else if (isGreater(element, currentRoot.value)) {
                currentRoot = currentRoot.rightChild;
            } else {
                return new BinarySearchTree<>(currentRoot);
            }
        }
        return result;
    }

    @Override
    public Node<E> getRoot() {
        return root;
    }

    @Override
    public Node<E> getLeft() {
        return leftChild;
    }

    @Override
    public Node<E> getRight() {
        return rightChild;
    }

    @Override
    public E getValue() {
        return root.value;
    }

    private boolean isLess(E first, E second) {
        return first.compareTo(second) < 0;
    }

    private boolean isGreater(E first, E second) {
        return first.compareTo(second) > 0;
    }

    private void copy(Node<E> element) {
        if (element == null){
            return;
        }

        insert(element.value);
        copy(element.leftChild);
        copy(element.rightChild);
    }
}
