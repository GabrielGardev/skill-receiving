package softuni.cardealer.services.impls;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.cardealer.domains.dtos.CustomerSeedDto;
import softuni.cardealer.domains.dtos.exportDtos.CarDto;
import softuni.cardealer.domains.dtos.exportDtos.CustomerDto;
import softuni.cardealer.domains.dtos.exportDtos.CustomerWithCarDto;
import softuni.cardealer.domains.dtos.exportDtos.SaleDto;
import softuni.cardealer.domains.entities.Car;
import softuni.cardealer.domains.entities.Customer;
import softuni.cardealer.domains.entities.Sale;
import softuni.cardealer.repositories.CustomerRepository;
import softuni.cardealer.services.CustomerService;
import softuni.cardealer.util.ComparatorFromHell;
import softuni.cardealer.util.ValidatorUtil;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final ValidatorUtil validator;
    private final ModelMapper mapper;
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(ValidatorUtil validator, ModelMapper mapper, CustomerRepository customerRepository) {
        this.validator = validator;
        this.mapper = mapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public void seedCustomers(CustomerSeedDto[] dtos) {
        for (CustomerSeedDto dto : dtos) {
            if (!this.validator.isValid(dto)){
                this.validator.violations(dto)
                        .forEach(x -> System.out.println(x.getMessage()));
            }

            Customer customer = this.mapper.map(dto, Customer.class);

            this.customerRepository.saveAndFlush(customer);
        }
    }

    @Override
    public List<CustomerDto> getOrderedCustomers() {

        List<Customer> customers = this.customerRepository.getAllOrderedByBirthDateThenByIsYoungDriver();

        List<CustomerDto> dtos = new ArrayList<>();

        for (Customer customer : customers) {

            CustomerDto customerDto = this.mapper.map(customer, CustomerDto.class);

            Set<Sale> sales = customer.getSales();

            SaleDto[] saleDtos = this.mapper.map(sales, SaleDto[].class);

            for (int i = 0; i < sales.size(); i++) {

                Sale currentSale = sales.toArray(Sale[]::new)[i];

                Car car = currentSale.getCar();

                CarDto carDto = this.mapper.map(car, CarDto.class);

                saleDtos[i].setCar(carDto);
                BigDecimal price = car.getParts().stream()
                        .map(x -> x.getPrice().multiply(BigDecimal.valueOf(x.getQuantity())))
                        .reduce(BigDecimal.ZERO, BigDecimal::add);

                saleDtos[i].setPrice(price);

                BigDecimal discount = currentSale.getDiscount();

                BigDecimal priceWithDiscount = (BigDecimal.valueOf(1.0).subtract(discount)).multiply(price);

                saleDtos[i].setPriceWithDiscount(priceWithDiscount);
            }

            customerDto.setSales(saleDtos);

            dtos.add(customerDto);

        }
        return dtos;
    }

    @Override
    public List<CustomerWithCarDto> getCustomersWithAtLeastOneBoughtCar() {

        List<Customer> customers = this.customerRepository.getAllWithAtLeastOneSale();

        customers = customers.stream().sorted(new ComparatorFromHell()).collect(Collectors.toList());

        List<CustomerWithCarDto> dtos = new ArrayList<>();

        for (Customer customer : customers) {

            CustomerWithCarDto dto = new CustomerWithCarDto();
            dto.setBoughtCars(customer.getSales().size());

            BigDecimal spendMoney = this.getTotalSpendMoney(customer);

            dto.setFullName(customer.getName());
            dto.setSpendMoney(spendMoney);
            dtos.add(dto);
        }

        return dtos;
    }

    private BigDecimal getTotalSpendMoney(Customer customer) {

        return customer.getSales()
                .stream()
                .map(x -> x.getCar()
                        .getParts()
                        .stream()
                        .map(y -> BigDecimal.valueOf(y.getQuantity()).multiply(y.getPrice()))
                        .reduce(BigDecimal.ZERO, BigDecimal::add))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
