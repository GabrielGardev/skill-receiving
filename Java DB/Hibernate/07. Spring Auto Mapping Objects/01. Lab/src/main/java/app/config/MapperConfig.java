package app.config;

import app.domain.dtos.EmployeeDTO;
import app.domain.dtos.ManagerDTO;
import app.domain.entities.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    private static final ModelMapper mapper;

    static {
        mapper = new ModelMapper();
        mapper.createTypeMap(Employee.class, EmployeeDTO.class)
                .addMapping(x -> x.getManager().getLastName(), EmployeeDTO::setManagerLastName);
        mapper.createTypeMap(Employee.class, ManagerDTO.class)
                .addMapping(Employee::getMinions, ManagerDTO::setEmployeeDTOS);
        mapper.createTypeMap(EmployeeDTO.class, Employee.class)
                .addMapping(EmployeeDTO::getManagerLastName, Employee::setManager);

    }

    @Bean
    public ModelMapper modelMapper() {
        return mapper;
    }
}
