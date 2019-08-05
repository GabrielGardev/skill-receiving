package alararestaurant.service;

import alararestaurant.domain.dtos.json.EmployeeDto;
import alararestaurant.domain.entities.Employee;
import alararestaurant.domain.entities.Position;
import alararestaurant.repository.EmployeeRepository;
import alararestaurant.repository.PositionRepository;
import alararestaurant.util.FileUtil;
import alararestaurant.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final static String EMPLOYEES_FILE_PATH = System.getProperty("user.dir") + "\\src\\main\\resources\\files\\employees.json";

    private final EmployeeRepository employeeRepository;
    private final PositionRepository positionRepository;
    private final FileUtil fileUtil;
    private final ModelMapper mapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, PositionRepository positionRepository, FileUtil fileUtil, ModelMapper mapper, Gson gson, ValidationUtil validationUtil) {
        this.employeeRepository = employeeRepository;
        this.positionRepository = positionRepository;
        this.fileUtil = fileUtil;
        this.mapper = mapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }


    @Override
    public Boolean employeesAreImported() {
        return this.employeeRepository.count() > 0;
    }

    @Override
    public String readEmployeesJsonFile() throws IOException {
        return fileUtil.readFile(EMPLOYEES_FILE_PATH);
    }

    @Override
    public String importEmployees(String employees) {
        StringBuilder sb = new StringBuilder();

        EmployeeDto[] dtos = gson.fromJson(employees, EmployeeDto[].class);
        for (EmployeeDto dto : dtos) {
            Employee employee = mapper.map(dto, Employee.class);
            if (!validationUtil.isValid(employee)){
                sb.append("Invalid data format.").append(System.lineSeparator());
                continue;
            }

            Position position = positionRepository.findByName(dto.getPosition());

            if (position == null){
                position = new Position();
                position.setName(dto.getPosition());

                if (!validationUtil.isValid(position)){
                    sb.append("Invalid data format.").append(System.lineSeparator());
                    continue;
                }
                positionRepository.saveAndFlush(position);
            }
            employee.setPosition(position);

            employeeRepository.saveAndFlush(employee);
            sb.append(String.format("Record %s successfully imported.", employee.getName()))
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
