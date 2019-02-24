package P06_Strategy_Pattern;

import java.util.Comparator;

public class CompareByName implements Comparator<Person> {
    @Override
    public int compare(Person first, Person second) {
        int result;
        result = first.getName().length() - second.getName().length();

        if (result == 0){
            result = first.getName().toLowerCase().charAt(0) - second.getName().toLowerCase().charAt(0);
        }
        return result;
    }
}
