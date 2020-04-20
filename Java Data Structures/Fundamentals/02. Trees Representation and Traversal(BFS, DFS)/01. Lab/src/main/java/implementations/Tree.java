package implementations;

import interfaces.AbstractTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Tree<E> implements AbstractTree<E> {
    private E key;
    private Tree<E> parent;
    private List<Tree<E>> children;

    public Tree(E key, Tree<E>... children) {
        this.key = key;
        this.children = new ArrayList<>();
        for (Tree<E> child : children) {
            this.children.add(child);
            child.parent = this;
        }
    }

    @Override
    public List<E> orderBfs() {
        List<E> result = new ArrayList<>();
        if (this.key == null) {
            return result;
        }
        Deque<Tree<E>> queue = new ArrayDeque<>();

        queue.offer(this);

        while (!queue.isEmpty()) {
            Tree<E> currentNode = queue.poll();
            result.add(currentNode.key);

            for (Tree<E> child : currentNode.children) {
                queue.offer(child);
            }
        }
        return result;
    }

    @Override
    public List<E> orderDfs() {
        List<E> result = new ArrayList<>();
        dfs(this, result);
        return result;
    }


    @Override
    public void addChild(E parentKey, Tree<E> child) {
        Tree<E> searched = find(parentKey);

        if (searched == null) {
            throw new IllegalArgumentException();
        }

        child.parent = searched;
        searched.children.add(child);
    }

    @Override
    public void removeNode(E nodeKey) {
        Tree<E> searched = find(nodeKey);

        if (searched == null) {
            throw new IllegalArgumentException();
        }

        if (searched.parent != null) {
            searched.parent.children.remove(searched);
        } else {
            searched.children = null;
            searched.key = null;
        }
    }

    @Override
    public void swap(E firstKey, E secondKey) {
        Tree<E> first = find(firstKey);
        Tree<E> second = find(secondKey);

        if (first == null || second == null){
            throw new IllegalArgumentException();
        }

        Tree<E> firstParent = first.parent;
        Tree<E> secondParent = second.parent;

        if (firstParent == null){
            swapRoot(second);
            return;
        }else if (secondParent == null){
            swapRoot(first);
            return;
        }

        first.parent = secondParent;
        second.parent = firstParent;

        int firstIndex = firstParent.children.indexOf(first);
        int secondIndex = secondParent.children.indexOf(second);

        firstParent.children.set(firstIndex, second);
        secondParent.children.set(secondIndex, first);
    }

    private void swapRoot(Tree<E> node) {
        this.key = node.key;
        this.parent = null;
        this.children = node.children;
        node.parent = null;
    }

    private void dfs(Tree<E> tree, List<E> result) {
        for (Tree<E> child : tree.children) {
            dfs(child, result);
        }
        result.add(tree.key);
    }

    private Tree<E> find(E parentKey) {
        Deque<Tree<E>> queue = new ArrayDeque<>();

        queue.offer(this);

        while (!queue.isEmpty()) {
            Tree<E> currentNode = queue.poll();

            if (currentNode.key.equals(parentKey)) {
                return currentNode;
            }

            for (Tree<E> currentChild : currentNode.children) {
                queue.offer(currentChild);
            }
        }
        return null;
    }
}



