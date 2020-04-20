package implementations;

import interfaces.AbstractTree;

import java.util.*;
import java.util.stream.Collectors;

public class Tree<E> implements AbstractTree<E> {
    private E value;
    private Tree<E> parent;
    private List<Tree<E>> children;

    public Tree(E value, Tree<E>... children) {
        this.value = value;
        this.children = new ArrayList<>();
        for (Tree<E> child : children) {
            child.setParent(this);
            this.children.add(child);
        }
    }

    @Override
    public void setParent(Tree<E> parent) {
        this.parent = parent;
    }

    @Override
    public void addChild(Tree<E> child) {
        children.add(child);
    }

    @Override
    public Tree<E> getParent() {
        return parent;
    }

    @Override
    public E getKey() {
        return value;
    }

    @Override
    public String getAsString() {
        StringBuilder builder = new StringBuilder();
        int level = 0;
        dfs(this, builder, level);
        return builder.toString().trim();
    }

    @Override
    public List<E> getLeafKeys() {
        return findAll()
                .stream()
                .filter(x -> x.children.isEmpty())
                .map(Tree::getKey)
                .collect(Collectors.toList());
    }

    @Override
    public List<E> getMiddleKeys() {
        return findAll()
                .stream()
                .filter(x -> !x.children.isEmpty() && x.parent != null)
                .map(Tree::getKey)
                .collect(Collectors.toList());
    }

    @Override
    public Tree<E> getDeepestLeftmostNode() {
        List<Tree<E>> trees = findAll();

        int maxPath = 0;
        Tree<E> result = null;

        for (Tree<E> tree : trees) {
            if (tree.isLeaf()) {
                int currentPath = getStepsFromLeafToRoot(tree);

                if (currentPath > maxPath) {
                    maxPath = currentPath;
                    result = tree;
                }
            }
        }
        return result;
    }

    @Override
    public List<E> getLongestPath() {
        List<E> result = new ArrayList<>();
        Tree<E> leftmostNode = getDeepestLeftmostNode();

        while (leftmostNode.parent != null) {
            result.add(leftmostNode.value);
            leftmostNode = leftmostNode.parent;
        }
        result.add(this.value);

        Collections.reverse(result);
        return result;
    }

    @Override
    public List<List<E>> pathsWithGivenSum(int sum) {
        List<List<E>> result = new ArrayList<>();
        List<Tree<E>> trees = findAll();

        for (Tree<E> tree : trees) {
            int currentSum = getSumFromLeafToRoot(tree);

            if (currentSum == sum) {
                List<E> currentList = new ArrayList<>();
                Tree<E> current = tree;

                while (current.parent != null) {
                    currentList.add(current.value);
                    current = current.parent;
                }
                currentList.add(this.value);
                Collections.reverse(currentList);
                result.add(currentList);
            }
        }

        return result;
    }

    private int getSumFromLeafToRoot(Tree<E> tree) {
        int result = 0;

        Tree<E> current = tree;

        while (current.parent != null) {
            result += (int) current.value;
            current = current.parent;
        }
        result += (int) this.value;

        return result;
    }

    @Override
    public List<Tree<E>> subTreesWithGivenSum(int sum) {
        List<Tree<E>> subtreeRoots = new ArrayList<>();

        getSubtreeRootWithSum(this, sum, subtreeRoots);

        return subtreeRoots;
    }

    private int getSubtreeRootWithSum(Tree<E> current, int targetSum, List<Tree<E>> result) {
        if (current == null) {
            return 0;
        }

        int currentSum = (int) current.value;

        for (Tree<E> child : current.children) {
            currentSum += getSubtreeRootWithSum(child, targetSum, result);
        }

        if (currentSum == targetSum) {
            result.add(current);
        }

        return currentSum;
    }

    private void dfs(Tree<E> tree, StringBuilder builder, int level) {
        for (int i = 0; i < level; i++) {
            builder.append(" ");
        }
        builder.append(tree.value)
                .append(System.lineSeparator());

        level += 2;

        for (Tree<E> child : tree.children) {
            dfs(child, builder, level);
        }
    }

    private List<Tree<E>> findAll() {
        List<Tree<E>> result = new ArrayList<>();
        Deque<Tree<E>> queue = new ArrayDeque<>();

        queue.offer(this);

        while (!queue.isEmpty()) {
            Tree<E> currentNode = queue.poll();

            result.add(currentNode);

            for (Tree<E> currentChild : currentNode.children) {
                queue.offer(currentChild);
            }
        }
        return result;
    }

    private int getStepsFromLeafToRoot(Tree<E> tree) {
        int counter = 0;
        Tree<E> current = tree;
        while (current.parent != null) {
            counter++;
            current = current.parent;
        }

        return counter;
    }

    private boolean isLeaf() {
        return this.children.isEmpty() && this.getParent() != null;
    }
}



