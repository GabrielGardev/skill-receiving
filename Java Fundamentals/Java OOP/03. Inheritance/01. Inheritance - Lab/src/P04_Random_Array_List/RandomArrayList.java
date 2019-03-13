package P04_Random_Array_List;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {
    private Random random;

    private Object getRandomElement(){
        int index = this.random.nextInt(super.size());
        Object element = super.get(index);
        super.remove(element);
        return element;
    }
}
