package com.example.xmlexersice.domain.dtos.exportDto.localsuppliers;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierExportRootDto {

    @XmlElement(name = "supplier")
    private SupplierExportDto[] supplierExportDtos;

    public SupplierExportRootDto() {
    }

    public SupplierExportDto[] getSupplierExportDtos() {
        return supplierExportDtos;
    }

    public void setSupplierExportDtos(SupplierExportDto[] supplierExportDtos) {
        this.supplierExportDtos = supplierExportDtos;
    }
}
