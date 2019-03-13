package P06_Animals;

public class Tomcat extends Cat {
    public Tomcat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "Give me one million b***h";
    }

    @Override
    protected void setGender(String gender) {
        super.setGender(gender);
    }
}
