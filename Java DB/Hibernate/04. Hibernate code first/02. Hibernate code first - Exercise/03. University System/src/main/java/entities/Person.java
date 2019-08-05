package entities;

import javax.persistence.*;

@MappedSuperclass
public abstract class Person {

    private int id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    public Person() {
    }

    public Person(String firstName, String lastName, String phoneNumber) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPhoneNumber(phoneNumber);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    @Column(name = "first_name", length = 30, nullable = false)
    public String getFirstName() {
        return firstName;
    }


    @Column(name = "last_name", length = 30, nullable = false)
    public String getLastName() {
        return lastName;
    }

    @Column(name = "phone_number", length = 15, nullable = false)
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
