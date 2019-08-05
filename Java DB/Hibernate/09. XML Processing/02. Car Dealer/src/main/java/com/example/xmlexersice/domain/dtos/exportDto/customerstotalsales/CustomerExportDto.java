package com.example.xmlexersice.domain.dtos.exportDto.customerstotalsales;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerExportDto {

    @XmlAttribute(name = "full-name")
    private String name;

    @XmlAttribute(name = "bought-cars")
    private Integer boughtCars;

    @XmlAttribute(name = "spent-money")
    private BigDecimal spentMoney;

    public CustomerExportDto() {
    }

    public String getName() {
        return name;
    }

    public void setFullName(String fullName) {
        this.name = fullName;
    }

    public Integer getBoughtCars() {
        return boughtCars;
    }

    public void setBoughtCars(Integer boughtCars) {
        this.boughtCars = boughtCars;
    }

    public BigDecimal getSpentMoney() {
        return spentMoney;
    }

    public void setSpentMoney(BigDecimal spentMoney) {
        this.spentMoney = spentMoney;
    }

    public void setName(String name) {
        this.name = name;
    }
}
