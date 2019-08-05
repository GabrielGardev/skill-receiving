package com.example.xmlexersice.service.impl;

import com.example.xmlexersice.domain.dtos.exportDto.customerstotalsales.CustomerExportDto;
import com.example.xmlexersice.domain.dtos.exportDto.customerstotalsales.CustomerExportRootDto;
import com.example.xmlexersice.domain.dtos.exportDto.orderedcustomers.CustomerExportOrderedRootDto;
import com.example.xmlexersice.domain.dtos.exportDto.orderedcustomers.CustomerOrderedExportDto;
import com.example.xmlexersice.domain.dtos.importDto.CustomerDto;
import com.example.xmlexersice.domain.dtos.importDto.CustomerRootDto;
import com.example.xmlexersice.domain.entities.Customer;
import com.example.xmlexersice.repository.CustomerRepository;
import com.example.xmlexersice.service.CustomerService;
import com.example.xmlexersice.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final static String XML_CUSTOMER_FILE_PATH =
            "C:\\Users\\Freeware Sys\\Projects\\Java DB\\Hibernate\\" +
                    "09. XML Processing\\02. Car Dealer\\src\\main\\resources\\xml\\customers.xml";

    private final static String ORDERED_CUSTOMERS = "C:\\Users\\Freeware Sys\\Projects\\Java DB\\Hibernate\\" +
            "09. XML Processing\\02. Car Dealer\\src\\main\\resources\\xml\\export\\ordered-customers.xml";

    private final static String CUSTOMERS_TOTAL_SALES = "C:\\Users\\Freeware Sys\\Projects\\Java DB\\Hibernate\\" +
            "09. XML Processing\\02. Car Dealer\\src\\main\\resources\\xml\\export\\customers-total-sales.xml";

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper, XmlParser xmlParser) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public void seedCustomers() throws JAXBException, FileNotFoundException {

        CustomerRootDto list = this.xmlParser.parseXml(CustomerRootDto.class, XML_CUSTOMER_FILE_PATH);

        for (CustomerDto customerDto: list.getCustomers()) {
            Customer customer = this.modelMapper.map(customerDto, Customer.class);
            customer.setBirthDate(LocalDate
                    .parse(customerDto.getBirthDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            this.customerRepository.saveAndFlush(customer);
        }
    }

    @Override
    public void exportCustomersOrdered() throws JAXBException {
        List<Customer> customers = this.customerRepository.getAllOrderedByBirthDateThenByIsYoungDriver();

        CustomerOrderedExportDto[] customerOrderedExportDtos = this.modelMapper.map(customers,CustomerOrderedExportDto[].class);

        CustomerExportOrderedRootDto dto = new CustomerExportOrderedRootDto();
        dto.setCustomerExportDtos(customerOrderedExportDtos);

        this.xmlParser.exportToXml(dto, ORDERED_CUSTOMERS);
    }

    @Override
    public void customersWithAtLeastOneBoughtCar() throws JAXBException {

        List<Customer> customers = this.customerRepository.getAllWithAtLeastOneSale();

        CustomerExportDto[] customerExportDtos = this.modelMapper.map(customers,CustomerExportDto[].class);

        for (int i = 0; i < customerExportDtos.length; i++) {

            CustomerExportDto customerExportDto = customerExportDtos[i];
            Customer customer = customers.get(i);

            customerExportDto.setBoughtCars(customer.getSales().size());
            customerExportDto.setSpentMoney(this.getTotalSpendMoney(customer));
        }


        CustomerExportRootDto dto = new CustomerExportRootDto();
        dto.setCustomerExportDtos(customerExportDtos);

        this.xmlParser.exportToXml(dto, CUSTOMERS_TOTAL_SALES);
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
