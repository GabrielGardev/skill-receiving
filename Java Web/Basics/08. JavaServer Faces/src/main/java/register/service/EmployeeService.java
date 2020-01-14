package register.service;

import register.domain.models.service.EmployeeServiceModel;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public interface EmployeeService {

    boolean saveEmployee(EmployeeServiceModel employeeServiceModel);

    List<EmployeeServiceModel> findAllEmployees();

    boolean deleteEmployee(String id);

    BigDecimal getTotalMoneyNeeded();

    Long getCountOfEmployees();
}
