package P06_Animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    private void setName(String name) {
        if (name.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 1){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    protected void setGender(String gender) {
        if (gender.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }

    protected String produceSound(){
        return "Not implemented!";
    }

    @Override
    public String toString() {
        return String.format("%s %d %s", this.name, this.age, this.gender);
    }
}
