package P03_Stack_Iterator;

import java.util.Iterator;

public class Stack<T> implements Iterable<T>{

    private Node top;

    public Stack() {
        this.top = null;
    }

    public void push(T element){
        Node node = new Node(element);
        if (this.top != null){
            node.prev = this.top;
        }
        this.top = node;
    }

    public T pop(){
       T element = this.top.element;
       this.top = this.top.prev;
       return element;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node currentTop = top;
            @Override
            public boolean hasNext() {
                return this.currentTop != null;
            }

            @Override
            public T next() {
                T result = this.currentTop.element;
                this.currentTop = this.currentTop.prev;
                return result;
            }
        };
    }


    public class Node {
        T element;
        Node prev;

        public Node(T element) {
            this.element = element;
            this.prev = null;
        }
    }

}
