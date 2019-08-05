package entities;

import orm.annotations.Column;
import orm.annotations.Id;

import java.sql.Date;

public class Car {
    @Id
    private int id;

    @Column(name = "model")
    private String model;

    @Column(name = "brand")
    private String brand;

    @Column(name = "year")
    private int year;

    @Column(name = "registration_date")
    private Date registrationDate;


    public Car() {
    }

    public Car(int id, String model, String brand, int year, Date registrationDate) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.year = year;
        this.registrationDate = registrationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
