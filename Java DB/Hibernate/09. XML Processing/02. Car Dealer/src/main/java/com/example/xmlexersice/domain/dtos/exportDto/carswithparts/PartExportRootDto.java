package com.example.xmlexersice.domain.dtos.exportDto.carswithparts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "parts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartExportRootDto {

    @XmlElement(name = "part")
    private List<PartExportDto> partExportDtos;

    public PartExportRootDto() {
    }

    public List<PartExportDto> getPartExportDtos() {
        return partExportDtos;
    }

    public void setPartExportDtos(List<PartExportDto> partExportDtos) {
        this.partExportDtos = partExportDtos;
    }
}