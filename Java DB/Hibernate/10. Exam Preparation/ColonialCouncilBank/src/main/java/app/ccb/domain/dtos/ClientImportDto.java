package app.ccb.domain.dtos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.validation.constraints.NotNull;

public class ClientImportDto {

    @Expose
    @SerializedName("first_name")
    private String firstName;

    @Expose
    @SerializedName("last_name")
    private String lastName;

    @Expose
    private Integer age;

    @Expose
    @SerializedName("appointed_employee")
    private String appointedEmployee;

    public ClientImportDto() {
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setAppointedEmployee(String appointedEmployee) {
        this.appointedEmployee = appointedEmployee;
    }

    @NotNull
    public String getFirstName() {
        return firstName;
    }

    @NotNull
    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getAppointedEmployee() {
        return appointedEmployee;
    }
}
