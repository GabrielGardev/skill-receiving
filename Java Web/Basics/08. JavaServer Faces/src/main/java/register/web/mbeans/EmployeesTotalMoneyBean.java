package register.web.mbeans;

import register.service.EmployeeService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;

@Named
@RequestScoped
public class EmployeesTotalMoneyBean {

    private BigDecimal totalMoney;

    private EmployeeService employeeService;

    public EmployeesTotalMoneyBean() {
    }

    @Inject
    public EmployeesTotalMoneyBean(EmployeeService employeeService) {
        this.employeeService = employeeService;
        this.totalMoney = this.employeeService.getTotalMoneyNeeded();
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }
}
