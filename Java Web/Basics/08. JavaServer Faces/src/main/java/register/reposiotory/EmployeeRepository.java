package register.reposiotory;

import register.domain.entities.Employee;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeRepository extends GenericRepository<Employee, String> {

    BigDecimal getTotalMoney();
}
