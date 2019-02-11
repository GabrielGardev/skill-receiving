package P04_List_Utilities;

import java.util.Collections;
import java.util.List;

public class ListUtils  {
    public static <T extends Comparable> T getMin(List<T> list){
        if (list.isEmpty()){
            throw new IllegalArgumentException();
        }

       return (T) Collections.min(list);
    }

    public static <T extends Comparable> T getMax(List<T> list){
        if (list.isEmpty()){
            throw new IllegalArgumentException();
        }

        return (T) Collections.max(list);
    }
}
