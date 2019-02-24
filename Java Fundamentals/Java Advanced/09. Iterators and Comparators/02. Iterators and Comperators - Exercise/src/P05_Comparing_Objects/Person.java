package P05_Comparing_Objects;

public class Person implements Comparable<Person>{
    private String name;
    private Integer age;
    private String town;

    public Person(String name, Integer age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getTown() {
        return town;
    }

    @Override
    public int compareTo(Person other) {
        int result;
        result = this.getName().compareTo(other.getName());
        if (result == 0){
            result = Integer.compare(this.getAge(), other.getAge());
        }

        if (result == 0){
            result = this.getTown().compareTo(other.getTown());
        }
        return result;
    }
}
