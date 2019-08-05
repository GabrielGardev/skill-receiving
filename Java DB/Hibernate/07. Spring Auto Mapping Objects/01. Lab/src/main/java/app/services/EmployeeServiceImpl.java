package app.services;

import app.domain.dtos.EmployeeDTO;
import app.domain.dtos.ManagerDTO;
import app.domain.entities.Employee;
import app.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private ModelMapper mapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

    @Override
    public void persist(String employeeData) {

        String[] employeeDataTokens = employeeData.split("\\s+");

        String firstName = employeeDataTokens[0];
        String lastName = employeeDataTokens[1];
        LocalDate birthday = LocalDate.parse(employeeDataTokens[2], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        BigDecimal salary = new BigDecimal(employeeDataTokens[3]);
        Boolean isOnHoliday = Boolean.parseBoolean(employeeDataTokens[4]);
        String address = employeeDataTokens[5];

        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setBirthday(birthday);
        employee.setSalary(salary);
        employee.setOnHoliday(isOnHoliday);
        employee.setAddress(address);

        this.employeeRepository.saveAndFlush(employee);
    }

    @Override
    public void setManagerToSomeEmployees(String id) {

        Long identity = Long.parseLong(id);

        if (identity <= this.employeeRepository.count()) {

            Employee manager = this.employeeRepository.getOne(identity);

            Long[] randomIds = new Long[2];

            for (int i = 0; i < randomIds.length; i++) {
                randomIds[i] = this.getRandomId();
            }

            for (Long randomId : randomIds) {
                this.employeeRepository.getOne(randomId).setManager(manager);
            }
        }
    }

    @Override
    public List<ManagerDTO> getAllManagers() {

        return this.employeeRepository.findAll()
                .stream()
                .map(x -> mapper.map(x, ManagerDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDTO> getAllEmployeeDTOS() {
        return this.employeeRepository.findAll()
                .stream()
                .map(x -> mapper.map(x, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public String addListOfEmployees(String employeeDTOSInfo) {

        String[] data = employeeDTOSInfo.split(";");

        List<EmployeeDTO> employeeDTOSList = new ArrayList<>();

        for (String token : data) {

            String[] employeeDTOInfo = token.split("\\s");

            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setFirstName(employeeDTOInfo[0]);
            employeeDTO.setLastName(employeeDTOInfo[1]);
            employeeDTO.setSalary(new BigDecimal(employeeDTOInfo[2]));
            employeeDTO.setManagerLastName(employeeDTOInfo[3]);

            employeeDTOSList.add(employeeDTO);

        }


        employeeDTOSList.stream().map(x->mapper.map(x,Employee.class)).forEach(this.employeeRepository::saveAndFlush);


        return employeeDTOSList.stream().map(EmployeeDTO::toString).collect(Collectors.joining(System.lineSeparator()));



    }

    private Long getRandomId() {

        Random random = new Random();

        long id = (long) random.nextInt((int) this.employeeRepository.count()) + 1;

        return id == 0 ? 1L : id;
    }
}
