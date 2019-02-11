package P08_Custom_List_Sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;

public class CustomList<T extends Comparable<T>> {
    private ArrayList<T> customList;

    public CustomList() {
        this.customList = new ArrayList<>();
    }

    public void add(T element){
        this.customList.add(element);
    }
    public T remove(int index){
        return this.customList.remove(index);
    }
    public boolean contains(T element){
        return this.customList.contains(element);
    }
    public void swap(int index, int index2){
        Collections.swap(this.customList, index, index2);
    }
    public long countGreater(T element){
       return this.customList.stream()
                .filter(e -> e.compareTo(element) > 0)
                .count();
    }
    public T max(){
        return this.customList.stream().max(T::compareTo).get();
    }
    public T min(){
        return this.customList.stream().min(T::compareTo).get();
    }
    public void forEach(Consumer<T> consumer){
        for (int i = 0; i < this.customList.size(); i++) {
            consumer.accept(this.customList.get(i));
        }
    }
    public int size(){
        return this.customList.size();
    }
    public T get(int index){
        return this.customList.get(index);
    }
}
