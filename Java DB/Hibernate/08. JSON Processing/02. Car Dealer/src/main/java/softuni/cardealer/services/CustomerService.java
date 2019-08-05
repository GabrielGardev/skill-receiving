package softuni.cardealer.services;

import softuni.cardealer.domains.dtos.CustomerSeedDto;
import softuni.cardealer.domains.dtos.exportDtos.CustomerDto;
import softuni.cardealer.domains.dtos.exportDtos.CustomerWithCarDto;

import java.util.List;

public interface CustomerService {

    void seedCustomers(CustomerSeedDto[] dtos);

    List<CustomerDto> getOrderedCustomers();

    List<CustomerWithCarDto> getCustomersWithAtLeastOneBoughtCar();
}
