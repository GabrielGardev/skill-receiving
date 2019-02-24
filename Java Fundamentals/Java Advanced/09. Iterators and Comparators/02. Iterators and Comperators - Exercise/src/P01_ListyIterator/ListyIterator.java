package P01_ListyIterator;

import java.util.Iterator;
import java.util.List;

public class ListyIterator {
    public static final int INTERN_INDEX = 0;
    private List<String> elements;
    private int currentIndex;

    public ListyIterator(List<String> elements) {
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
}
