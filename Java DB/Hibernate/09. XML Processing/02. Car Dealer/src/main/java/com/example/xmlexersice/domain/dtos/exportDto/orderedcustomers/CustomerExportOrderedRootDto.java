package com.example.xmlexersice.domain.dtos.exportDto.orderedcustomers;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerExportOrderedRootDto {

    @XmlElement(name = "customer")
    private CustomerOrderedExportDto[] customerExportDtos;

    public CustomerExportOrderedRootDto() {
    }

    public CustomerOrderedExportDto[] getCustomerExportDtos() {
        return customerExportDtos;
    }

    public void setCustomerExportDtos(CustomerOrderedExportDto[] customerExportDtos) {
        this.customerExportDtos = customerExportDtos;
    }
}
