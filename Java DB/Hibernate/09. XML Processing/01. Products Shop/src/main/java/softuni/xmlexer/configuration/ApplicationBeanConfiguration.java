package softuni.xmlexer.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import softuni.xmlexer.util.*;


@Configuration
public class ApplicationBeanConfiguration {

    private static ModelMapper mapper = new ModelMapper();
    private static ValidatorUtil validator = new ValidatorUtilImpl();
    private static XmlParserImpl xmlParser = new XmlParserImpl();

    @Bean
    public ValidatorUtil validatorUtilImpl(){
        return validator;
    }

    @Bean
    public ModelMapper modelMapper(){
        return mapper;
    }

    @Bean
    public XmlParserImpl xmlParser(){
        return xmlParser;
    }
}
