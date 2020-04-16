import implementations.ReversedList;
import interfaces.ReversedListInter;

public class Main {
    public static void main(String[] args) {
        ReversedListInter<Integer> integers = new ReversedList<>();

        integers.add(13);
        integers.add(13);
        integers.add(13);
        integers.add(13);
        integers.add(13);
        integers.add(13);
        integers.add(13);
        integers.add(13);
        integers.add(13);



        integers.removeAt(0);

        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
