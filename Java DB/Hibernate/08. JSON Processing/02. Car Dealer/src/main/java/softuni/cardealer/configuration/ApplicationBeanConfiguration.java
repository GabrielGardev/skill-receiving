package softuni.cardealer.configuration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import softuni.cardealer.util.FileUtilImpl;
import softuni.cardealer.util.LocalDateJsonConverter;
import softuni.cardealer.util.ValidatorUtilImpl;

import java.time.LocalDateTime;


@Configuration
public class ApplicationBeanConfiguration {
    private static ModelMapper mapper = new ModelMapper();
    private static FileUtilImpl fileUtil = new FileUtilImpl();
    private static ValidatorUtilImpl validator = new ValidatorUtilImpl();
    private static Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .setPrettyPrinting()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateJsonConverter())
            .create();

    @Bean
    public Gson gson() {
        return  gson;
    }

    @Bean
    public FileUtilImpl fileUtilImpl(){
      return fileUtil;
    }

    @Bean
    public ValidatorUtilImpl validatorUtilImpl(){
        return validator;
    }

    @Bean
    public ModelMapper modelMapper(){
        return mapper;
    }
}
