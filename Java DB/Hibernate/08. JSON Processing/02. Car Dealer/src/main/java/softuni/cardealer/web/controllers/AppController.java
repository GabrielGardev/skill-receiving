package softuni.cardealer.web.controllers;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import softuni.cardealer.domains.dtos.*;
import softuni.cardealer.domains.dtos.exportDtos.*;
import softuni.cardealer.services.*;
import softuni.cardealer.util.FileUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Controller
public class AppController implements CommandLineRunner {
    private final static String SUPPLIERS_PATH = "C:\\Users\\Freeware Sys\\Projects\\Java DB\\Hibernate\\" +
            "08. JSON Processing\\02. Car Dealer\\src\\main\\resources\\suppliers.json";

    private final static String PARTS_PATH = "C:\\Users\\Freeware Sys\\Projects\\Java DB\\Hibernate\\" +
            "08. JSON Processing\\02. Car Dealer\\src\\main\\resources\\parts.json";

    private final static String CARS_PATH = "C:\\Users\\Freeware Sys\\Projects\\Java DB\\Hibernate\\" +
            "08. JSON Processing\\02. Car Dealer\\src\\main\\resources\\cars.json";

    private final static String CUSTOMERS_PATH = "C:\\Users\\Freeware Sys\\Projects\\Java DB\\Hibernate\\" +
            "08. JSON Processing\\02. Car Dealer\\src\\main\\resources\\customers.json";

    private final static String TASK_ONE_EXPORT_FILE = "C:\\Users\\Freeware Sys\\Projects\\Java DB\\Hibernate\\" +
            "08. JSON Processing\\02. Car Dealer\\src\\main\\resources\\export\\ordered_customers.json";

    private final static String TASK_TWO_EXPORT_FILE = "C:\\Users\\Freeware Sys\\Projects\\Java DB\\Hibernate\\" +
            "08. JSON Processing\\02. Car Dealer\\src\\main\\resources\\export\\all_toyotas.json";

    private static final String TASK_THREE_EXPORT_FILE = "C:\\Users\\Freeware Sys\\Projects\\Java DB\\Hibernate\\" +
            "08. JSON Processing\\02. Car Dealer\\src\\main\\resources\\export\\not_important_parts.json";

    private static final String TASK_FOUR_EXPORT_FILE = "C:\\Users\\Freeware Sys\\Projects\\Java DB\\Hibernate\\" +
            "08. JSON Processing\\02. Car Dealer\\src\\main\\resources\\export\\cars_with_parts.json";

    private static final String TASK_FIVE_EXPORT_FILE = "C:\\Users\\Freeware Sys\\Projects\\Java DB\\Hibernate\\" +
            "08. JSON Processing\\02. Car Dealer\\src\\main\\resources\\export\\sales_by_customers.json";

    private static final String TASK_SIX_EXPORT_FILE = "C:\\Users\\Freeware Sys\\Projects\\Java DB\\Hibernate\\" +
            "08. JSON Processing\\02. Car Dealer\\src\\main\\resources\\export\\sales_with_applied_discount.json";


    private final FileUtil fileUtil;
    private final Gson gson;
    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;
    private final SaleService saleService;

    @Autowired
    public AppController(FileUtil fileUtil, Gson gson, SupplierService supplierService, PartService partService, CarService carService, CustomerService customerService, SaleService saleService) {
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = saleService;
    }

    @Override
    public void run(String... args) throws Exception {
        //this.seedSuppliers();
        //this.seedParts();
        //this.seedCars();
        //this.seedCustomers();
        //this.seedRandomSales();

        //Task 1
        //this.orderedCustomers();

        //Task 2
        //this.getCarsFromMakeToyota();

        //Task 3
        //this.getLocalSuppliers();

        //Task 4
        //this.getCarsWithTheirParts();

        //Task 5
        //this.getTotalSalesByCustomer();

        //Task 6
        //this.salesWithAppliedDiscount();
    }

    private void seedRandomSales() {
        this.saleService.seedRandomSales();
    }

    private void seedCustomers() throws IOException {
        String content = fileUtil.fileContent(CUSTOMERS_PATH);

        CustomerSeedDto[] dtos = this.gson.fromJson(content, CustomerSeedDto[].class);

        this.customerService.seedCustomers(dtos);
    }

    private void seedCars() throws IOException {
        String content = fileUtil.fileContent(CARS_PATH);

        CarSeedDto[] dtos = this.gson.fromJson(content, CarSeedDto[].class);

        this.carService.seedCars(dtos);
    }

    private void seedParts() throws IOException {
        String content = fileUtil.fileContent(PARTS_PATH);

        PartSeedDto[] dtos = this.gson.fromJson(content, PartSeedDto[].class);

        this.partService.seedParts(dtos);
    }

    private void seedSuppliers() throws IOException {
        String content = fileUtil.fileContent(SUPPLIERS_PATH);

        SupplierSeedDto[] dtos = this.gson.fromJson(content, SupplierSeedDto[].class);

        this.supplierService.seedSuppliers(dtos);
    }

    private void orderedCustomers() throws IOException {
        List<CustomerDto> dtos = this.customerService.getOrderedCustomers();
        writeItAll(this.gson.toJson(dtos), TASK_ONE_EXPORT_FILE);
    }

    private void getCarsFromMakeToyota() throws IOException {
        ToyotaDto[] dtos = this.carService.getCarsFromMakeToyota();
        writeItAll(this.gson.toJson(dtos), TASK_TWO_EXPORT_FILE);
    }

    private void getLocalSuppliers() throws IOException {
        LocalSuppliersDto[] dtos = this.supplierService.getLocalSuppliers();
        writeItAll(this.gson.toJson(dtos), TASK_THREE_EXPORT_FILE);
    }

    private void getCarsWithTheirParts() throws IOException {
        List<CombineCarsPartsDto> dtos = this.carService.getCarsWithParts();
        writeItAll(this.gson.toJson(dtos), TASK_FOUR_EXPORT_FILE);
    }

    private void getTotalSalesByCustomer() throws IOException {
        List<CustomerWithCarDto> dtos = this.customerService.getCustomersWithAtLeastOneBoughtCar();
        writeItAll(this.gson.toJson(dtos), TASK_FIVE_EXPORT_FILE);
    }
    private void salesWithAppliedDiscount() throws IOException {
        List<SaleDto> dtos = this.saleService.getWithAppliedDiscount();
        writeItAll(this.gson.toJson(dtos), TASK_SIX_EXPORT_FILE);
    }

    private void writeItAll(String dtos, String path) throws IOException {
        File file = new File(path);
        writeToFile(dtos, file);
    }

    private void writeToFile(String orderedCustomersJson, File file) throws IOException {
        FileWriter writer = new FileWriter(file);

        writer.write(orderedCustomersJson);

        writer.close();
    }
}
