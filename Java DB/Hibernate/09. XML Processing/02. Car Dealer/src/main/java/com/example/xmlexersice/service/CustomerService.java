package com.example.xmlexersice.service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.List;

public interface CustomerService {

    void seedCustomers() throws JAXBException, FileNotFoundException;

    void exportCustomersOrdered() throws JAXBException;

    void customersWithAtLeastOneBoughtCar() throws JAXBException;
}
