package softuni.cardealer.services.impls;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.cardealer.domains.dtos.SupplierSeedDto;
import softuni.cardealer.domains.dtos.exportDtos.LocalSuppliersDto;
import softuni.cardealer.domains.entities.Supplier;
import softuni.cardealer.repositories.SupplierRepository;
import softuni.cardealer.services.SupplierService;
import softuni.cardealer.util.ValidatorUtil;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Set;


@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;
    private final ValidatorUtil validator;
    private final ModelMapper mapper;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository, ValidatorUtil validator, ModelMapper mapper) {
        this.supplierRepository = supplierRepository;
        this.validator = validator;
        this.mapper = mapper;
    }

    @Override
    public void seedSuppliers(SupplierSeedDto[] supplierSeedDtos) {

        for (SupplierSeedDto dto : supplierSeedDtos) {
            if (!this.validator.isValid(dto)){
                this.validator.violations(dto)
                        .forEach(x -> System.out.println(x.getMessage()));
                continue;
            }

            Supplier supplier = this.mapper.map(dto, Supplier.class);

            this.supplierRepository.saveAndFlush(supplier);
        }
    }

    @Override
    public LocalSuppliersDto[] getLocalSuppliers() {
        List<Supplier> suppliers = this.supplierRepository.getAllByImporterIsFalse();

        LocalSuppliersDto[] dtos = this.mapper.map(suppliers, LocalSuppliersDto[].class);
        for (int i = 0; i < suppliers.size(); i++) {
            dtos[i].setPartsCount(suppliers.get(i).getParts().size());
        }

        return dtos;
    }
}
