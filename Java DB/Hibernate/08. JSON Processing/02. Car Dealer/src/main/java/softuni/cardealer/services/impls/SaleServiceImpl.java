package softuni.cardealer.services.impls;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.cardealer.domains.dtos.exportDtos.CarDto;
import softuni.cardealer.domains.dtos.exportDtos.SaleDto;
import softuni.cardealer.domains.entities.Car;
import softuni.cardealer.domains.entities.Customer;
import softuni.cardealer.domains.entities.Sale;
import softuni.cardealer.repositories.CarRepository;
import softuni.cardealer.repositories.CustomerRepository;
import softuni.cardealer.repositories.SaleRepository;
import softuni.cardealer.services.SaleService;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.*;

@Service
@Transactional
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;
    private final ModelMapper mapper;


    private static final BigDecimal[] DISCOUNTS = {
            BigDecimal.ZERO, new BigDecimal(0.05),
            new BigDecimal(0.1), new BigDecimal(0.15),
            new BigDecimal(0.2), new BigDecimal(0.3),
            new BigDecimal(0.4), new BigDecimal(0.5)};

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository, CarRepository carRepository, CustomerRepository customerRepository, ModelMapper mapper) {
        this.saleRepository = saleRepository;
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
        this.mapper = mapper;
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

    @Override
    public List<SaleDto> getWithAppliedDiscount() {

        List<Sale> sales = this.saleRepository.findAll();

        List<SaleDto> dtos = new ArrayList<>();

        for (Sale sale : sales) {

            SaleDto saleDto = this.mapper.map(sale, SaleDto.class);

            CarDto carDto = this.mapper.map(sale.getCar(), CarDto.class);

            saleDto.setCar(carDto);

            BigDecimal price = sale.getCar()
                    .getParts()
                    .stream()
                    .map(x -> x.getPrice().multiply(BigDecimal.valueOf(x.getQuantity())))
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            saleDto.setPrice(price);

            BigDecimal priceWithDiscount = (BigDecimal.valueOf(1.0).subtract(sale.getDiscount())).multiply(price);

            saleDto.setPriceWithDiscount(priceWithDiscount);

            dtos.add(saleDto);

        }

        return dtos;

    }

    private Sale getRandomSale(int carRepositoryCount, int customerRepositoryCount) {

        BigDecimal randomDiscount = this.getRandomDiscount();

        Car randomCar = this.getRandomCar(carRepositoryCount);

        Customer randomCustomer = this.getRandomCustomer(customerRepositoryCount);

        Sale sale = new Sale();
        sale.setCar(randomCar);
        sale.setCustomer(randomCustomer);

        if (randomCustomer.isYoungDriver()){
            randomDiscount = randomDiscount.add(BigDecimal.valueOf(0.05));
        }

        sale.setDiscount(randomDiscount);

        return sale;

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

    private BigDecimal getRandomDiscount() {

        Random random = new Random();

        int randomIndex = random.nextInt(DISCOUNTS.length);

        return DISCOUNTS[randomIndex];
    }
}
