package com.example.xmlexersice.service.impl;

import com.example.xmlexersice.domain.dtos.exportDto.saleswithdiscount.SaleExportDto;
import com.example.xmlexersice.domain.dtos.exportDto.saleswithdiscount.SaleExportRootDto;
import com.example.xmlexersice.domain.entities.Car;
import com.example.xmlexersice.domain.entities.Customer;
import com.example.xmlexersice.domain.entities.Sale;
import com.example.xmlexersice.repository.CarRepository;
import com.example.xmlexersice.repository.CustomerRepository;
import com.example.xmlexersice.repository.SaleRepository;
import com.example.xmlexersice.service.SaleService;
import com.example.xmlexersice.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
@Transactional
public class SaleServiceImpl implements SaleService {

    private final static String SALES_DISCOUNT = "C:\\Users\\Freeware Sys\\Projects\\Java DB\\Hibernate\\" +
            "09. XML Processing\\02. Car Dealer\\src\\main\\resources\\xml\\export\\sales-discounts.xml";

    private static final Double[] DISCOUNTS = {
            0.0, 0.05,
            0.1, 0.15,
            0.2, 0.3,
            0.4, 0.5};

    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;
    private final SaleRepository saleRepository;
    private final ModelMapper mapper;
    private final XmlParser xmlParser;

    public SaleServiceImpl(CarRepository carRepository, CustomerRepository customerRepository, SaleRepository saleRepository, ModelMapper mapper, XmlParser xmlParser) {
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
        this.saleRepository = saleRepository;
        this.mapper = mapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public void seedRandomSales() {
            int carRepositoryCount = (int) this.carRepository.count();
            int customerRepositoryCount = (int) this.customerRepository.count();

            int randomSalesCount = new Random().nextInt(11) + 10;

            Set<Sale> sales = new HashSet<>();

            for (int i = 0; i < randomSalesCount; i++) {

                Sale sale = this.getRandomSale(carRepositoryCount, customerRepositoryCount);

                if (!sales.add(sale)) {

                    randomSalesCount++;
                }
            }
            this.saleRepository.saveAll(sales);
            this.saleRepository.flush();
    }

    private Sale getRandomSale(int carRepositoryCount, int customerRepositoryCount) {

        Double randomDiscount = this.getRandomDiscount();

        Car randomCar = this.getRandomCar(carRepositoryCount);

        Customer randomCustomer = this.getRandomCustomer(customerRepositoryCount);

        Sale sale = new Sale();
        sale.setCar(randomCar);
        sale.setCustomer(randomCustomer);

        if (isDriverYounger(randomCustomer)){
            randomDiscount = randomDiscount + 0.05;
        }

        sale.setDiscount(randomDiscount);

        return sale;

    }

    private boolean isDriverYounger(Customer randomCustomer) {
        return randomCustomer.getYoungDriver();
    }

    private Customer getRandomCustomer(int upperBound) {

        Random random = new Random();
        int randomId = random.nextInt(upperBound) + 1;

        return this.customerRepository.getOne(randomId);
    }

    private Car getRandomCar(int upperBound) {

        Random random = new Random();
        int randomId = random.nextInt(upperBound) + 1;

        return this.carRepository.getOne(randomId);
    }

    private Double getRandomDiscount() {

        Random random = new Random();

        int randomIndex = random.nextInt(DISCOUNTS.length);

        return DISCOUNTS[randomIndex];
    }

    @Override
    public void getSalesWithAppliedDiscount() throws JAXBException {

        List<Sale> sales = this.saleRepository.getAllWithDiscount();

        SaleExportRootDto dto = new SaleExportRootDto();

        SaleExportDto[] saleExportDtos = this.mapper.map(sales, SaleExportDto[].class);

        for (int i = 0, saleExportDtosLength = saleExportDtos.length; i < saleExportDtosLength; i++) {

            SaleExportDto saleExportDto = saleExportDtos[i];

            Sale sale = sales.get(i);

            BigDecimal price = sale.getCar()
                    .getParts()
                    .stream()
                    .map(x -> x.getPrice().multiply(BigDecimal.valueOf(x.getQuantity())))
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            saleExportDto.setPrice(price);

            BigDecimal priceWithDiscount = (BigDecimal.valueOf(1).subtract(BigDecimal.valueOf(sale.getDiscount()))).multiply(price);

            saleExportDto.setPriceWithDiscount(priceWithDiscount);
        }

        dto.setSales(saleExportDtos);

        this.xmlParser.exportToXml(dto, SALES_DISCOUNT);
    }
}
