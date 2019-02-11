package P02_Generic_Array_Creator;

import java.lang.reflect.Array;

public final class  ArrayCreator {


   public static <T> T[] create(int length, T item) {
        T[] arr = (T[]) Array.newInstance(item.getClass(), length);

       for (int i = 0; i < length; i++) {
           arr[i] = item;
       }
       return arr;
    }

    public static <T> T[] create(Class<T> tClass, int length, T item) {
        T[] arr = (T[]) Array.newInstance(tClass, length);

        for (int i = 0; i < length; i++) {
            arr[i] = item;
        }
        return arr;
    }
}
