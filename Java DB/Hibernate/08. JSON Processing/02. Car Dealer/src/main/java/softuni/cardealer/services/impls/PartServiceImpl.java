package softuni.cardealer.services.impls;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.cardealer.domains.dtos.PartSeedDto;
import softuni.cardealer.domains.entities.Part;
import softuni.cardealer.domains.entities.Supplier;
import softuni.cardealer.repositories.PartRepository;
import softuni.cardealer.repositories.SupplierRepository;
import softuni.cardealer.services.PartService;
import softuni.cardealer.util.ValidatorUtil;

import java.util.Random;

@Service
public class PartServiceImpl implements PartService {

    private final ValidatorUtil validator;
    private final ModelMapper mapper;
    private final PartRepository partRepository;
    private final SupplierRepository supplierRepository;

    @Autowired
    public PartServiceImpl(ValidatorUtil validator, ModelMapper mapper, PartRepository partRepository, SupplierRepository supplierRepository) {
        this.validator = validator;
        this.mapper = mapper;
        this.partRepository = partRepository;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public void seedParts(PartSeedDto[] dtos) {
        for (PartSeedDto dto : dtos) {
            if (!this.validator.isValid(dto)){
                this.validator.violations(dto)
                        .forEach(x -> System.out.println(x.getMessage()));
            }
            Part part = this.mapper.map(dto, Part.class);
            part.setSupplier(this.getRandomSupplier());

            this.partRepository.saveAndFlush(part);
        }
    }

    private Supplier getRandomSupplier() {
        Random random = new Random();

        int id = random.nextInt((int) this.supplierRepository.count()) + 1;

        return this.supplierRepository.getOne(id);
    }
}
