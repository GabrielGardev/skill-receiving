package softuni.cardealer.services;

import softuni.cardealer.domains.dtos.CarSeedDto;
import softuni.cardealer.domains.dtos.exportDtos.CombineCarsPartsDto;
import softuni.cardealer.domains.dtos.exportDtos.ToyotaDto;

import java.util.List;

public interface CarService {

    void seedCars(CarSeedDto[] dtos);

    ToyotaDto[] getCarsFromMakeToyota();

    List<CombineCarsPartsDto> getCarsWithParts();
}
