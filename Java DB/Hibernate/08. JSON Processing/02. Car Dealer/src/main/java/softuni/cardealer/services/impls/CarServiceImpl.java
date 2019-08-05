package softuni.cardealer.services.impls;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.cardealer.domains.dtos.CarSeedDto;
import softuni.cardealer.domains.dtos.exportDtos.CarDto;
import softuni.cardealer.domains.dtos.exportDtos.CombineCarsPartsDto;
import softuni.cardealer.domains.dtos.exportDtos.PartDto;
import softuni.cardealer.domains.dtos.exportDtos.ToyotaDto;
import softuni.cardealer.domains.entities.Car;
import softuni.cardealer.domains.entities.Part;
import softuni.cardealer.repositories.CarRepository;
import softuni.cardealer.repositories.PartRepository;
import softuni.cardealer.services.CarService;
import softuni.cardealer.util.ValidatorUtil;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    private final ValidatorUtil validator;
    private final ModelMapper mapper;
    private final CarRepository carRepository;
    private final PartRepository partRepository;

    @Autowired
    public CarServiceImpl(ValidatorUtil validator, ModelMapper mapper, CarRepository carRepository, PartRepository partRepository) {
        this.validator = validator;
        this.mapper = mapper;
        this.carRepository = carRepository;
        this.partRepository = partRepository;
    }

    @Override
    public void seedCars(CarSeedDto[] dtos) {
        for (CarSeedDto dto : dtos) {
            if (!this.validator.isValid(dto)){
                this.validator.violations(dto)
                        .forEach(x -> System.out.println(x.getMessage()));
            }

            Car car = this.mapper.map(dto, Car.class);

            car.setParts(this.getRandomParts());

            this.carRepository.saveAndFlush(car);
        }
    }

    @Override
    public ToyotaDto[] getCarsFromMakeToyota() {
        String make = "Toyota";
        Set<Car> cars = this.carRepository.findAllByMakeOrderByModelAscTravelledDistanceDesc(make);

        return this.mapper.map(cars, ToyotaDto[].class);
    }

    @Override
    public List<CombineCarsPartsDto> getCarsWithParts() {
        List<Car> allCars = this.carRepository.findAll();

        List<CombineCarsPartsDto> dtos = new ArrayList<>();

        for (Car car : allCars) {
            Set<Part> parts = car.getParts();

            CarDto carr = this.mapper.map(car, CarDto.class);
            PartDto[] partDtos = this.mapper.map(parts, PartDto[].class);

            CombineCarsPartsDto carsPartsDto = new CombineCarsPartsDto();
            carsPartsDto.setCar(carr);
            carsPartsDto.setParts(partDtos);

            dtos.add(carsPartsDto);
        }

        return dtos;
    }

    private Set<Part> getRandomParts() {

        // random size between 10 and 20
        Random random = new Random();

        int size = random.nextInt(11) + 10;

        Set<Part> parts = new HashSet<>();

        for (int i = 0; i < size; i++) {

            Part part = this.getRandomPart();

            if (!parts.add(part)) {
                size++;
            }
        }

        return parts;
    }

    private Part getRandomPart() {

        Random random = new Random();

        int randomId = random.nextInt((int) this.partRepository.count()) + 1;

        return this.partRepository.getOne(randomId);
    }
}
