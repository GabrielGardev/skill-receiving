package softuni.softunigamestore.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappingConfiguration {
    static ModelMapper modelMapper;

    static {
        modelMapper = new ModelMapper();

        modelMapper.validate();
    }

    @Bean
    public ModelMapper mapper() {
        return modelMapper;
    }
}