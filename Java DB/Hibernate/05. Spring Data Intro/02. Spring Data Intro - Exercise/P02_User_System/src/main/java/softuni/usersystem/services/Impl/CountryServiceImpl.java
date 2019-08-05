package softuni.usersystem.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.usersystem.entities.Country;
import softuni.usersystem.repositories.CountryRepository;
import softuni.usersystem.services.CountryService;
import softuni.usersystem.utils.FileUtil;

import java.io.IOException;


@Service
public class CountryServiceImpl implements CountryService {
    //Dont forgot to change the @PATH when you test
    private static final String COUNTIES_PATH = "C:\\Users\\Freeware Sys\\Projects\\Java DB\\" +
            "Hibernate\\05. Spring Data Intro\\02. Spring Data Intro - Exercise\\" +
            "P02_User_System\\src\\main\\resources\\files\\countries";

    private final CountryRepository countryRepository;
    private final FileUtil fileUtil;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository, FileUtil fileUtil) {
        this.countryRepository = countryRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedCountries() throws IOException {
        if (this.countryRepository.count() > 0){
            return;
        }

        for (String[] data : fileUtil.fileContent(COUNTIES_PATH)) {
            Country country = new Country();
            country.setName(data[0]);
            this.countryRepository.saveAndFlush(country);
        }
    }
}
