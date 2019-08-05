package softuni.cardealer.services;

import softuni.cardealer.domains.dtos.PartSeedDto;

public interface PartService {
    void seedParts(PartSeedDto[] dtos);
}
