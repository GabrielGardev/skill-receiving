package P07_Equality_Logic;

public class Person implements Comparable<Person>{
    private String name;
    private Integer age;


    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.name.hashCode();
        result = 31 * result + this.age;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            return this.hashCode() - obj.hashCode() == 0;
        }
        return false;
    }

    @Override
    public int compareTo(Person o) {
        int result;
        result = this.getName().compareTo(o.getName());
        if (result == 0){
            result = this.getAge().compareTo(o.getAge());
        }
        return result;
    }
}
