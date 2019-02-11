package P04_List_Utilities;

import java.lang.reflect.Array;
import java.nio.charset.IllegalCharsetNameException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1 ,5 ,6 ,3, 6);
        Integer max = ListUtils.getMax(arr);
    }
}
