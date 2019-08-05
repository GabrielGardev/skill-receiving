package com.example.xmlexersice.service.impl;

import com.example.xmlexersice.domain.dtos.exportDto.carswithparts.CarExportDto;
import com.example.xmlexersice.domain.dtos.exportDto.carswithparts.CarExportRootDto;
import com.example.xmlexersice.domain.dtos.exportDto.carswithparts.PartExportDto;
import com.example.xmlexersice.domain.dtos.exportDto.carswithparts.PartExportRootDto;
import com.example.xmlexersice.domain.dtos.exportDto.toyotacars.ToyotaExportDto;
import com.example.xmlexersice.domain.dtos.exportDto.toyotacars.ToyotaExportRootDto;
import com.example.xmlexersice.domain.dtos.importDto.CarDto;
import com.example.xmlexersice.domain.dtos.importDto.CarRootDto;
import com.example.xmlexersice.domain.entities.Car;
import com.example.xmlexersice.domain.entities.Part;
import com.example.xmlexersice.repository.CarRepository;
import com.example.xmlexersice.service.CarService;
import com.example.xmlexersice.service.PartService;
import com.example.xmlexersice.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    private final static String XML_CAR_FILE_PATH =
            "C:\\Users\\Freeware Sys\\Projects\\Java DB\\Hibernate\\09. XML Processing\\02. Car Dealer\\src\\main\\resources\\xml\\cars.xml";
    private final static String XML_CAR_EXPORT_FILE_PATH =
            "C:\\Users\\Freeware Sys\\Projects\\Java DB\\Hibernate\\09. XML Processing\\02. Car Dealer\\src\\main\\resources\\xml\\export\\cars-and-parts.xml";

    private final static String TOYOTA_CARS = "C:\\Users\\Freeware Sys\\Projects\\Java DB\\Hibernate\\" +
            "09. XML Processing\\02. Car Dealer\\src\\main\\resources\\xml\\export\\toyota-cars.xml";

    private final CarRepository carRepository;
    private final PartService partService;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, PartService partService, ModelMapper modelMapper, XmlParser xmlParser) {
        this.carRepository = carRepository;
        this.partService = partService;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public void seedCars() throws JAXBException, FileNotFoundException {
        CarRootDto list = this.xmlParser.parseXml(CarRootDto.class, XML_CAR_FILE_PATH);

        for (CarDto carDto: list.getCarDtoList()) {
           carDto.setParts(this.partService.getRandomParts());

           this.carRepository.saveAndFlush(this.modelMapper.map(carDto, Car.class));
        }
    }

    @Override
    public void exportCars() throws JAXBException {
        List<Car> cars = this.carRepository.findAll();

        List<CarExportDto> carExportDtos = new ArrayList<>();
        for (Car car : cars) {
            CarExportDto carExportDto = this.modelMapper.map(car, CarExportDto.class);
            List<PartExportDto> partExportDtos = new ArrayList<>();

            for (Part part : car.getParts() ) {
                PartExportDto partExportDto = this.modelMapper.map(part, PartExportDto.class);

                partExportDtos.add(partExportDto);
            }

            PartExportRootDto partExportRootDto = new PartExportRootDto();
            partExportRootDto.setPartExportDtos(partExportDtos);
            carExportDto.setPartExportRootDto(partExportRootDto);

            carExportDtos.add(carExportDto);
        }

        CarExportRootDto carExportRootDto = new CarExportRootDto();
        carExportRootDto.setCarExportDtos(carExportDtos);

        this.xmlParser.exportToXml(carExportRootDto ,XML_CAR_EXPORT_FILE_PATH );
    }

    @Override
    public void carsWithMakeToyota() throws JAXBException {

        List<Car> cars = this.carRepository.getAllByMakeOrderByModelThenByTravelledDistanceDesc("Toyota");

        ToyotaExportDto[] toyotaExportDtos = this.modelMapper.map(cars,ToyotaExportDto[].class);

        ToyotaExportRootDto dto = new ToyotaExportRootDto();

        dto.setToyotaExportDtos(toyotaExportDtos);

        this.xmlParser.exportToXml(dto, TOYOTA_CARS);
    }

}
