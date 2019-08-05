package com.example.xmlexersice.service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface CarService {

    void seedCars() throws JAXBException, FileNotFoundException;

    void exportCars() throws JAXBException;

    void carsWithMakeToyota() throws JAXBException;
}
