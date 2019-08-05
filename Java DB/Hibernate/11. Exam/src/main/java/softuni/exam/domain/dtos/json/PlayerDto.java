package softuni.exam.domain.dtos.json;

import com.google.gson.annotations.Expose;
import softuni.exam.domain.entities.Picture;
import softuni.exam.domain.entities.Team;
import softuni.exam.domain.entities.enums.Position;

import java.math.BigDecimal;

public class PlayerDto {

    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private int number;

    @Expose
    private BigDecimal salary;

    @Expose
    private Position position;

    @Expose
    private JsonPictureDto picture;

    @Expose
    private JsonTeamDto team;


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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
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


    public JsonPictureDto getPicture() {
        return picture;
    }

    public void setPicture(JsonPictureDto picture) {
        this.picture = picture;
    }

    public JsonTeamDto getTeam() {
        return team;
    }

    public void setTeam(JsonTeamDto team) {
        this.team = team;
    }
}
