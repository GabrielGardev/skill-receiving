package P03_Repository;

public class Person {
    private String name;
    private Integer age;
    private String birthDate;

    public Person(String name, Integer age, String birthDate) {
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return String.format("Name: %s%n" +
                "Age: %d%n" +
                "Birthday: %s", this.name, this.age, this.birthDate);
    }
}
