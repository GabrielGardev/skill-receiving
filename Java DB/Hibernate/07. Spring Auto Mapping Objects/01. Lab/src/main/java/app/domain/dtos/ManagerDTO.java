package app.domain.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ManagerDTO {

    private String firstName;

    private String lastName;

    private List<EmployeeDTO> employeeDTOS;

    public ManagerDTO() {
        this.employeeDTOS = new ArrayList<>();
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

    public List<EmployeeDTO> getEmployeeDTOS() {
        return employeeDTOS;
    }

    public void setEmployeeDTOS(List<EmployeeDTO> employeeDTOS) {
        this.employeeDTOS = employeeDTOS;
    }

    @Override
    public String toString() {
        return String.format("%s %s | Employees: %d\n%s",
                this.getFirstName(),
                this.getLastName(),
                this.employeeDTOS.size(),
                this.employeeDTOS.stream()
                        .map(EmployeeDTO::toString)
                        .collect(Collectors.joining(System.lineSeparator())));
    }
}

