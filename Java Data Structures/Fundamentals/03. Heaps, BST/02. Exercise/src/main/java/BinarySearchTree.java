import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.function.Consumer;

import java.util.List;

public class BinarySearchTree<E extends Comparable<E>> {
    private Node<E> root;

    public BinarySearchTree() {
    }

    public BinarySearchTree(E element) {
        this.root = new Node<>(element);
    }

    public BinarySearchTree(Node<E> otherRoot){
        this.root = new Node<>(otherRoot);
    }

    public static class Node<E> {
        private E value;
        private Node<E> leftChild;
        private Node<E> rightChild;
        private int count;

        public Node(E value) {
            this.value = value;
            this.count = 1;
        }

        public Node(Node<E> other) {
            this.value = other.value;
            this.count = other.count;

            if (other.getLeft() != null) {
                this.leftChild = new Node<>(other.getLeft());
            }

            if (other.getRight() != null) {
                this.rightChild = new Node<>(other.getRight());
            }
        }

        public Node<E> getLeft() {
            return this.leftChild;
        }

        public Node<E> getRight() {
            return this.rightChild;
        }

        public E getValue() {
            return this.value;
        }

        public int getCount() {
            return this.count;
        }
    }

    public void eachInOrder(Consumer<E> consumer) {
        inOrder(root, consumer);
    }

    private void inOrder(Node<E> node, Consumer<E> consumer) {
        if (node == null) {return;}

        inOrder(node.getLeft(), consumer);
        consumer.accept(node.getValue());
        inOrder(node.getRight(), consumer);
    }

    public Node<E> getRoot() {
        return root;
    }

    public void insert(E element) {
        if (this.root == null){
            this.root = new Node<>(element);
        }else {
            insertInto(root, element);
        }
    }

    private void insertInto(Node<E> node, E element) {
        if (isGreater(element, node)) {
            if (node.getRight() == null) {
                node.rightChild = new Node<>(element);
            } else {
                insertInto(node.getRight(), element);
            }
        } else if (isLess(element, node)) {
            if (node.getLeft() == null) {
                node.leftChild = new Node<>(element);
            } else {
                insertInto(node.getLeft(), element);
            }
        }

        node.count++;
    }

    public boolean contains(E element) {
        Node<E> currentRoot = getRoot();

        while (currentRoot != null) {
            if (isLess(element, currentRoot)) {
                currentRoot = currentRoot.leftChild;
            } else if (isGreater(element, currentRoot)) {
                currentRoot = currentRoot.rightChild;
            } else {
                return true;
            }
        }
        return false;
    }

    public BinarySearchTree<E> search(E element) {
        Node<E> found = containsNode(getRoot(), element);

        return found != null ? new BinarySearchTree<>(found) : null;
    }

    private Node<E> containsNode(Node<E> node, E element) {

        if (node == null) {
            return null;
        }

        if (areEqual(element, node)) {
            return node;
        }

        if (isLess(element, node)) {
            return containsNode(node.getLeft(), element);
        } else {
            return containsNode(node.getRight(), element);
        }
    }

    public List<E> range(E lower, E upper) {
        List<E> result = new ArrayList<>();

        if (root == null){
            return result;
        }

        Deque<Node<E>> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            Node<E> current = queue.poll();

            if (current.getLeft() != null){
                queue.offer(current.getLeft());
            }
            if (current.getRight() != null){
                queue.offer(current.getRight());
            }

            if (isLess(lower, current) && isGreater(upper, current)){
                result.add(current.getValue());
            }else if (areEqual(lower, current) || areEqual(upper, current)){
                result.add(current.getValue());
            }
        }

        return result;
    }

    public void deleteMin() {
        ensureNonEmpty();

        if (getRoot().getLeft() == null){
            root = root.getRight();
            return;
        }

        Node<E> current = this.root;
        while (current.getLeft().getLeft() != null){
            current.count--;
            current = current.getLeft();
        }

        current.count--;
        current.leftChild = current.getLeft().getRight();
    }

    public void deleteMax() {
        ensureNonEmpty();

        if (getRoot().getRight() == null){
            root = root.getLeft();
            return;
        }

        Node<E> current = this.root;
        while (current.getRight().getRight() != null){
            current.count--;
            current = current.getRight();
        }
        current.count--;
        current.rightChild = current.getRight().getLeft();
    }

    public int count() {
        return getRoot() == null ? 0 : getRoot().getCount();
    }

    public int rank(E element) {
        return nodeRank(getRoot(), element);
    }

    public E floor(E element) {
        Node<E> current = getRoot();
        Node<E> nearestSmaller = null;

        while (current != null){
            if (isGreater(element, current)){
                nearestSmaller = current;
                current = current.getRight();
            }else if (isLess(element, current)){
                current = current.getLeft();
            }else {
                Node<E> left = current.getLeft();
                if (left != null & nearestSmaller != null){
                    nearestSmaller = isGreater(left.getValue(), nearestSmaller) ? left : nearestSmaller;
                }else if (nearestSmaller == null){
                    nearestSmaller = left;
                }
                break;
            }
        }
        return nearestSmaller == null ? null : nearestSmaller.getValue();
    }


    public E ceil(E element) {
        Node<E> current = getRoot();
        Node<E> nearestBigger = null;

        while (current != null){
            if (isLess(element, current)) {
                nearestBigger = current;
                current = current.getLeft();
            }else if (isGreater(element, current)){
                current = current.getRight();
            }else {
                Node<E> right = current.getRight();
                if (right != null && nearestBigger != null){
                    nearestBigger = isLess(right.getValue(), nearestBigger) ? right : nearestBigger;
                }else if (nearestBigger == null){
                    nearestBigger = right;
                }
                break;
            }
        }
        return nearestBigger == null ? null : nearestBigger.getValue();
    }

    private boolean areEqual(E element, Node<E> node) {
        return element.compareTo(node.getValue()) == 0;
    }

    private boolean isLess(E element, Node<E> node) {
        return element.compareTo(node.getValue()) < 0;
    }

    private boolean isGreater(E element, Node<E> node) {
        return element.compareTo(node.getValue()) > 0;
    }

    private void ensureNonEmpty() {
        if(getRoot() == null){
            throw new IllegalArgumentException();
        }
    }

    private int nodeRank(Node<E> node, E element) {
        if (node == null) { return 0; }

        if (isLess(element, node)){
            return nodeRank(node.getLeft(), element);
        }else if (areEqual(element, node)){
            return getNodeCount(node.getLeft());
        }

        return getNodeCount(node.getLeft()) + 1 + nodeRank(node.getRight(), element);
    }

    private int getNodeCount(Node<E> node) {
        return node == null ? 0 : node.getCount();
    }
}