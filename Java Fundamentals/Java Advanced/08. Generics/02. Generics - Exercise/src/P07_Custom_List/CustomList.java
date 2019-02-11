package P07_Custom_List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;

public class CustomList<T extends Comparable<T>> {
    private ArrayList<T> smartArray;

    public CustomList() {
        this.smartArray = new ArrayList<>();
    }

    public void add(T element){
        this.smartArray.add(element);
    }
    public T remove(int index){
        return this.smartArray.remove(index);
    }
    public boolean contains(T element){
        return this.smartArray.contains(element);
    }
    public void swap(int index, int index2){
        Collections.swap(this.smartArray, index, index2);
    }
    public long countGreater(T element){
       return this.smartArray.stream()
                .filter(e -> e.compareTo(element) > 0)
                .count();
    }
    public T max(){
        return this.smartArray.stream().max(T::compareTo).get();
    }
    public T min(){
        return this.smartArray.stream().min(T::compareTo).get();
    }
    public void forEach(Consumer<T> consumer){
        for (int i = 0; i < this.smartArray.size(); i++) {
            consumer.accept(this.smartArray.get(i));
        }
    }
}
