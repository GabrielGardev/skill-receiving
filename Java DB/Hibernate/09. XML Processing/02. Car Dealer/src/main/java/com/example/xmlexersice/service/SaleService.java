package com.example.xmlexersice.service;

import javax.xml.bind.JAXBException;

public interface SaleService {
    void seedRandomSales();

    void getSalesWithAppliedDiscount() throws JAXBException;
}
