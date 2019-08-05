package app.ccb.services;

import app.ccb.domain.dtos.EmployeeImportDto;
import app.ccb.domain.entities.Branch;
import app.ccb.domain.entities.Client;
import app.ccb.domain.entities.Employee;
import app.ccb.repositories.BranchRepository;
import app.ccb.repositories.EmployeeRepository;
import app.ccb.util.FileUtil;
import app.ccb.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final static String EMPLOYEES_JSON_FILE_PATH = "C:\\Users\\hp\\IdeaProjects\\ColonialCouncilBank\\src\\main\\resources\\files\\json\\employees.json";

    private final EmployeeRepository employeeRepository;

    private final BranchRepository branchRepository;

    private final FileUtil fileUtil;

    private final Gson gson;

    private final ValidationUtil validationUtil;

    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, BranchRepository branchRepository, FileUtil fileUtil, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.branchRepository = branchRepository;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean employeesAreImported() {
        return this.employeeRepository.count() != 0;
    }

    @Override
    public String readEmployeesJsonFile() throws IOException {

        return this.fileUtil.readFile(EMPLOYEES_JSON_FILE_PATH);
    }

    @Override
    public String importEmployees(String employeesJson) {

        StringBuilder importResult = new StringBuilder();

        EmployeeImportDto[] employeeImportDtos = this.gson.fromJson(employeesJson, EmployeeImportDto[].class);

        for (EmployeeImportDto employeeImportDto : employeeImportDtos) {

            if (!this.validationUtil.isValid(employeeImportDto)) {

                importResult.append("Error: Incorrect Data!").append(System.lineSeparator());
                continue;
            }

            Branch branch = this.branchRepository.findByName(employeeImportDto.getBranchName()).orElse(null);

            if (branch == null) {

                importResult.append("Error: Incorrect Data!").append(System.lineSeparator());
                continue;
            }

            Employee employee = this.modelMapper.map(employeeImportDto, Employee.class);
            employee.setFirstName(employeeImportDto.getFullName().split("\\s+")[0]);
            employee.setLastName(employeeImportDto.getFullName().split("\\s+")[1]);
            employee.setBranch(branch);
            employee.setStartedOn(LocalDate.parse(employeeImportDto.getStatedOn()));
            this.employeeRepository.saveAndFlush(employee);

            importResult.append(String.format("Successfully imported Employee - %s", employeeImportDto.getFullName()))
                    .append(System.lineSeparator());
        }


        return importResult.toString().trim();
    }

    @Override
    public String exportTopEmployees() {


        List<Employee> employees = this.employeeRepository.findTopEmployees();

        StringBuilder exportResult = new StringBuilder();

        for (Employee employee : employees) {

            exportResult.append(String.format("Full Name: %s", employee.getFirstName() + " " + employee.getLastName()))
                    .append(System.lineSeparator())
                    .append(String.format("Salary: %.2f", employee.getSalary()))
                    .append(System.lineSeparator())
                    .append(String.format("Started On: %s", employee.getStartedOn()))
                    .append(System.lineSeparator())
                    .append("Clients:")
                    .append(System.lineSeparator());

            for (Client client : employee.getClients()) {

                exportResult.append(String.format("   %s", client.getFullName()))
                        .append(System.lineSeparator());
            }

        }

        return exportResult.toString().trim();
    }
}
