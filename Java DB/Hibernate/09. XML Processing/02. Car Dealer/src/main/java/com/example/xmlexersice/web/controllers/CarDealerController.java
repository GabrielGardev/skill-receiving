package com.example.xmlexersice.web.controllers;

import com.example.xmlexersice.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class CarDealerController implements CommandLineRunner {

    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;
    private final SaleService saleService;

    @Autowired
    public CarDealerController(SupplierService supplierService, PartService partService, CarService carService, CustomerService customerService, SaleService saleService) {
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = saleService;
    }

    @Override
    public void run(String... args) throws Exception {
        //this.supplierService.seedSuppliers();
        //this.partService.seedParts();
        //this.carService.seedCars();
        //this.customerService.seedCustomers();
        //this.saleService.seedRandomSales();

        //Task 01
        //this.customerService.exportCustomersOrdered();

        //Task 02
        //this.carService.carsWithMakeToyota();

        //Task 03
        //this.supplierService.localSuppliers();

        //Task 04
        //this.carService.exportCars();

        //Task 05
        //this.customerService.customersWithAtLeastOneBoughtCar();

        //Task 06
        this.saleService.getSalesWithAppliedDiscount();
    }

}
