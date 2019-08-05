package com.example.xmlexersice.domain.dtos.importDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "parts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartRootDto {

    @XmlElement(name = "part")
    private List<PartDto> partDtos;

    public PartRootDto() {
    }

    public List<PartDto> getPartDtos() {
        return partDtos;
    }

    public void setPartDtos(List<PartDto> partDtos) {
        this.partDtos = partDtos;
    }
}
