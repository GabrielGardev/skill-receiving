package register.service;

import org.modelmapper.ModelMapper;
import register.domain.entities.Employee;
import register.domain.models.service.EmployeeServiceModel;
import register.reposiotory.EmployeeRepositoryImpl;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepositoryImpl employeeRepository;
    private final ModelMapper modelMapper;

    @Inject
    public EmployeeServiceImpl(EmployeeRepositoryImpl employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean saveEmployee(EmployeeServiceModel employeeServiceModel) {
        try {
            employeeRepository.save(modelMapper.map(employeeServiceModel, Employee.class));
        }catch (Exception e){
            return false;
        }

        return true;
    }

    @Override
    public List<EmployeeServiceModel> findAllEmployees() {
        return this.employeeRepository.findAll()
                .stream()
                .map(x -> this.modelMapper.map(x, EmployeeServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteEmployee(String id) {

        try {
            this.employeeRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public BigDecimal getTotalMoneyNeeded() {
        return this.employeeRepository.getTotalMoney();
    }

    @Override
    public Long getCountOfEmployees() {
        return this.employeeRepository.getCount();
    }
}
