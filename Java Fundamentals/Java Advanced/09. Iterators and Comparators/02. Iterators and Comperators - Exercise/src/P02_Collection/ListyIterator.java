package P02_Collection;

import java.util.Iterator;
import java.util.List;

public class ListyIterator<T> implements Iterable<T>{
    public static final int INTERN_INDEX = 0;
    private List<T> elements;
    private int currentIndex;

    public ListyIterator(List<T> elements) {
        this.elements = elements;
        this.currentIndex = INTERN_INDEX;
    }

    public boolean Move(){
        if (this.currentIndex < this.elements.size()- 1){
            this.currentIndex++;
            return true;
        }
        return false;
    }

    public boolean HasNext(){
        if (this.currentIndex < this.elements.size()- 1){
            return true;
        }
        return false;
    }

    public void PrintAtCurrentIndex(){
        if (this.elements.isEmpty()){
            System.out.println("Invalid Operation!");
        }else {
            System.out.println(this.elements.get(this.currentIndex));
        }
    }

    public List<T> getElements() {
        return elements;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return this.index < elements.size();
            }

            @Override
            public T next() {
                return elements.get(index++);
            }
        };

    }
}
