package softuni.cardealer.services;

import softuni.cardealer.domains.dtos.exportDtos.SaleDto;

import java.util.List;

public interface SaleService {

    void seedRandomSales();

    List<SaleDto> getWithAppliedDiscount();
}
