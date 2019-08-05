package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "wizard_deposits")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class WizardDeposit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50)
    private String first_name;

    @Column(length = 60, nullable = false)
    private String last_name;

    @Column(length = 1000)
    private String notes;

    @Column(nullable = false, columnDefinition = "INT UNSIGNED")
    private int age;

    @Column(length = 100)
    private String magic_wand_creator;

    @Column
    private int magic_want_size;

    @Column(length = 20)
    private String deposit_group;

    @Column
    private Date deposit_start_date;

    @Column
    private double deposit_amount;

    @Column
    private double deposit_interest;

    @Column
    private double deposit_charge;

    @Column(columnDefinition = "DATETIME")
    private Date deposit_expiration_date;

    @Column
    private boolean is_deposit_expired;

    public WizardDeposit() {
    }

    public WizardDeposit(String last_name, int age) {
        this.last_name = last_name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMagic_wand_creator() {
        return magic_wand_creator;
    }

    public void setMagic_wand_creator(String magic_wand_creator) {
        this.magic_wand_creator = magic_wand_creator;
    }

    public int getMagic_want_size() {
        return magic_want_size;
    }

    public void setMagic_want_size(int magic_want_size) {
        this.magic_want_size = magic_want_size;
    }

    public String getDeposit_group() {
        return deposit_group;
    }

    public void setDeposit_group(String deposit_group) {
        this.deposit_group = deposit_group;
    }

    public Date getDeposit_start_date() {
        return deposit_start_date;
    }

    public void setDeposit_start_date(Date deposit_start_date) {
        this.deposit_start_date = deposit_start_date;
    }

    public double getDeposit_amount() {
        return deposit_amount;
    }

    public void setDeposit_amount(double deposit_amount) {
        this.deposit_amount = deposit_amount;
    }

    public double getDeposit_interest() {
        return deposit_interest;
    }

    public void setDeposit_interest(double deposit_interest) {
        this.deposit_interest = deposit_interest;
    }

    public double getDeposit_charge() {
        return deposit_charge;
    }

    public void setDeposit_charge(double deposit_charge) {
        this.deposit_charge = deposit_charge;
    }

    public Date getDeposit_expiration_date() {
        return deposit_expiration_date;
    }

    public void setDeposit_expiration_date(Date deposit_expiration_date) {
        this.deposit_expiration_date = deposit_expiration_date;
    }

    public boolean isIs_deposit_expired() {
        return is_deposit_expired;
    }

    public void setIs_deposit_expired(boolean is_deposit_expired) {
        this.is_deposit_expired = is_deposit_expired;
    }
}
