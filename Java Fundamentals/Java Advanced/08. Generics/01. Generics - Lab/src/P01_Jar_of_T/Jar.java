package P01_Jar_of_T;

import java.util.ArrayDeque;

public class Jar<T> {
    private ArrayDeque<T> stack = new ArrayDeque<>();

    public void add(T element) {
        stack.push(element);
    }

    public T remove(){
        return stack.pop();
    }
}
