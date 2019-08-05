package com.example.xmlexersice.service;

import com.example.xmlexersice.domain.dtos.importDto.SupplierDto;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface SupplierService {

    void seedSuppliers() throws JAXBException, FileNotFoundException;

    SupplierDto getRandomSupplier();

    void localSuppliers() throws JAXBException;
}
