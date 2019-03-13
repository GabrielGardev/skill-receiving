package P07_Border_Control;

public class Citizen implements Identifiable{
    private String name;
    private int age;
    private String id;

    Citizen(String name, int age, String id) {
        this.setName(name);
        this.setAge(age);
        this.setId(id);
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

}
