package softuni.exam.domain.entities;

import org.hibernate.validator.constraints.Length;
import softuni.exam.domain.entities.enums.Position;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "players")
public class Player extends BaseEntity{

    @Column(name = "first_name", nullable = false)
    @NotNull
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @NotNull
    @Length(min = 3, max = 15)
    private String lastName;

    @Column(nullable = false)
    @NotNull
    @Min(1)
    @Max(99)
    private Integer number;

    @Column(nullable = false)
    @NotNull
    @DecimalMin("0")
    private BigDecimal salary;

    @Column(nullable = false)
    @NotNull
    @Enumerated(EnumType.STRING)
    private Position position;

    @NotNull
    @ManyToOne(targetEntity = Picture.class)
    @JoinColumn(name = "picture_id", referencedColumnName = "id", nullable = false)
    private Picture picture;

    @NotNull
    @ManyToOne(targetEntity = Team.class)
    @JoinColumn(name = "team_id", referencedColumnName = "id", nullable = false)
    private Team team;

    public Player() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
