package app.services;

import app.domain.dtos.EmployeeDTO;
import app.domain.dtos.ManagerDTO;
import app.domain.entities.Employee;

import java.util.List;

public interface EmployeeService {

    void persist(String employeeData);

    void setManagerToSomeEmployees(String id);

    List<ManagerDTO> getAllManagers();

    List<EmployeeDTO> getAllEmployeeDTOS();

    String addListOfEmployees(String employeeDTOSInfo);
}
