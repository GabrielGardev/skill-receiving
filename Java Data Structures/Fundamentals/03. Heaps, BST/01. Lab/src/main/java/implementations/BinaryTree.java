package implementations;

import interfaces.AbstractBinaryTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class BinaryTree<E> implements AbstractBinaryTree<E> {
    private E key;
    private BinaryTree<E> left;
    private BinaryTree<E> right;

    public BinaryTree(E key, BinaryTree<E> left, BinaryTree<E> right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    @Override
    public E getKey() {
        return key;
    }

    @Override
    public AbstractBinaryTree<E> getLeft() {
        return left;
    }

    @Override
    public AbstractBinaryTree<E> getRight() {
        return right;
    }

    @Override
    public void setKey(E key) {
        this.key = key;
    }

    @Override
    public String asIndentedPreOrder(int indent) {
        StringBuilder result = new StringBuilder();
        String padding = createPadding(indent);

        result.append(padding).append(getKey());

        if (getLeft() != null){
            String leftResult = getLeft().asIndentedPreOrder(indent + 2);
            result.append(System.lineSeparator()).append(leftResult);
        }

        if (getRight() != null){
            String rightResult = getRight().asIndentedPreOrder(indent + 2);
            result.append(System.lineSeparator()).append(rightResult);
        }

        return result.toString();
    }

    @Override
    public List<AbstractBinaryTree<E>> preOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        result.add(this);

        if (getLeft() != null){
            result.addAll(getLeft().preOrder());
        }

        if (getRight() != null){
            result.addAll(getRight().preOrder());
        }
        return result;
    }

    @Override
    public List<AbstractBinaryTree<E>> inOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();

        if (getLeft() != null){
            result.addAll(getLeft().inOrder());
        }

        result.add(this);

        if (getRight() != null){
            result.addAll(getRight().inOrder());
        }
        return result;
    }

    @Override
    public List<AbstractBinaryTree<E>> postOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();

        if (getLeft() != null){
            result.addAll(getLeft().postOrder());
        }

        if (getRight() != null){
            result.addAll(getRight().postOrder());
        }
        result.add(this);

        return result;
    }

    @Override
    public void forEachInOrder(Consumer<E> consumer) {
        if (getLeft() != null){
            getLeft().forEachInOrder(consumer);
        }

        consumer.accept(getKey());

        if (getRight() != null){
            getRight().forEachInOrder(consumer);
        }
    }

    private String createPadding(int indent) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < indent; i++) {
            builder.append(" ");
        }
        return builder.toString();
    }
}
