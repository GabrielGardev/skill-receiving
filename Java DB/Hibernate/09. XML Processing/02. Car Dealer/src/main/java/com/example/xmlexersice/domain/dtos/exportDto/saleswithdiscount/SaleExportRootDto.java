package com.example.xmlexersice.domain.dtos.exportDto.saleswithdiscount;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "sales")
@XmlAccessorType(XmlAccessType.FIELD)
public class SaleExportRootDto {

    @XmlElement(name = "sale")
    private SaleExportDto[] sales;

    public SaleExportRootDto() {
    }

    public SaleExportDto[] getSales() {
        return sales;
    }

    public void setSales(SaleExportDto[] sales) {
        this.sales = sales;
    }
}
