package P04_Froggy;

import java.util.Iterator;
import java.util.List;

public class Lake<T> implements Iterable<T> {
    private List<T> lake;
    private int lastEvenIndex;

    public Lake(List<T> lake) {
        this.lake = lake;
        this.setLastEvenIndex();
    }

    public void setLastEvenIndex() {
        if ((this.lake.size() - 1) % 2 == 0){
            this.lastEvenIndex = this.lake.size() - 1;
        }else {
            this.lastEvenIndex = this.lake.size() - 2;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                if (this.index - 2 == lastEvenIndex && lake.size() > 1){
                    this.index = 1;
                }
                return this.index < lake.size();
            }

            @Override
            public T next() {
                T num = lake.get(this.index);
                this.index += 2;
                return num;
            }
        };
    }
}
