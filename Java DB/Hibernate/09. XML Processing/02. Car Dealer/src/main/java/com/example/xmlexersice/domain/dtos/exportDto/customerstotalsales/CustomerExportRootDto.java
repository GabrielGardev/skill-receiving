package com.example.xmlexersice.domain.dtos.exportDto.customerstotalsales;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerExportRootDto {

    @XmlElement(name = "customer")
    private CustomerExportDto[] customerExportDtos;

    public CustomerExportRootDto() {
    }

    public CustomerExportDto[] getCustomerExportDtos() {
        return customerExportDtos;
    }

    public void setCustomerExportDtos(CustomerExportDto[] customerExportDtos) {
        this.customerExportDtos = customerExportDtos;
    }
}
