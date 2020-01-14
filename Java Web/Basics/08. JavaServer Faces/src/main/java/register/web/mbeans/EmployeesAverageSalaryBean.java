package register.web.mbeans;

import register.service.EmployeeService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Named
@RequestScoped
public class EmployeesAverageSalaryBean {

    private BigDecimal averageSalary;

    private EmployeeService employeeService;

    public EmployeesAverageSalaryBean() {
    }

    @Inject
    public EmployeesAverageSalaryBean(EmployeeService employeeService) {
        this.employeeService = employeeService;
        this.calculateAverageSalary();
    }

    public BigDecimal getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(BigDecimal averageSalary) {
        this.averageSalary = averageSalary;
    }

    private void calculateAverageSalary() {

        BigDecimal totalMoney = this.employeeService.getTotalMoneyNeeded();

        BigDecimal average = BigDecimal.ZERO;

        if (totalMoney.compareTo(BigDecimal.valueOf(0)) > 0) {
            average = totalMoney.divide(BigDecimal.valueOf(this.employeeService.getCountOfEmployees()), RoundingMode.CEILING);
        }

        this.setAverageSalary(average);
    }
}
