package softuni.usersystem.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.usersystem.entities.Country;
import softuni.usersystem.entities.Town;
import softuni.usersystem.repositories.CountryRepository;
import softuni.usersystem.repositories.TownRepository;
import softuni.usersystem.services.TownService;
import softuni.usersystem.utils.FileUtil;

import java.io.IOException;

@Service
public class TownServiceImpl implements TownService {
    //Dont forgot to change the @PATH when you test
    private static final String TOWNS_PATH = "C:\\Users\\Freeware Sys\\Projects\\Java DB\\Hibernate\\" +
            "05. Spring Data Intro\\" +
            "02. Spring Data Intro - Exercise\\P02_User_System\\src\\main\\resources\\files\\towns";

    private final TownRepository townRepository;
    private final CountryRepository countryRepository;
    private final FileUtil fileUtil;
    @Autowired
    public TownServiceImpl(TownRepository townRepository, CountryRepository countryRepository, FileUtil fileUtil) {
        this.townRepository = townRepository;
        this.countryRepository = countryRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedTowns() throws IOException {
        if (this.townRepository.count() > 0){
            return;
        }

        for (String[] strings : this.fileUtil.fileContent(TOWNS_PATH)) {
            Town town = new Town();
            town.setName(strings[0]);

            Country country = this.countryRepository.getOne(Integer.parseInt(strings[1]));
            town.setCountry(country);
            this.townRepository.saveAndFlush(town);
        }
    }
}
