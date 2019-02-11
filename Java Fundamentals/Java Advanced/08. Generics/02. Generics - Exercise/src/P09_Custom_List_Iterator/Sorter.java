package P09_Custom_List_Iterator;

public class Sorter<T extends Comparable<T>> {
    public static void sort(CustomList list){
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0){
                    list.swap(i,j);
                }
            }
        }
    }
}
