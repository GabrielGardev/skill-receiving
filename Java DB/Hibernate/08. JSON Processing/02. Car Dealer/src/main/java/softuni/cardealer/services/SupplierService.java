package softuni.cardealer.services;

import softuni.cardealer.domains.dtos.SupplierSeedDto;
import softuni.cardealer.domains.dtos.exportDtos.LocalSuppliersDto;

public interface SupplierService {

    void seedSuppliers(SupplierSeedDto[] supplierSeedDtos);

    LocalSuppliersDto[] getLocalSuppliers();
}
