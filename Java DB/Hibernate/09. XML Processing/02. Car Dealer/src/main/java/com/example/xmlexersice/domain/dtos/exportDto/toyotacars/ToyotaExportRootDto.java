package com.example.xmlexersice.domain.dtos.exportDto.toyotacars;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class ToyotaExportRootDto {

    @XmlElement(name = "car")
    private ToyotaExportDto[] toyotaExportDtos;

    public ToyotaExportRootDto() {
    }

    public ToyotaExportDto[] getToyotaExportDtos() {
        return toyotaExportDtos;
    }

    public void setToyotaExportDtos(ToyotaExportDto[] toyotaExportDtos) {
        this.toyotaExportDtos = toyotaExportDtos;
    }
}
