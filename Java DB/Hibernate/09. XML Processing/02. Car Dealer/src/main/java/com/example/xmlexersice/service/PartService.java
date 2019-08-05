package com.example.xmlexersice.service;

import com.example.xmlexersice.domain.dtos.importDto.PartDto;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.List;

public interface PartService {

    void seedParts() throws JAXBException, FileNotFoundException;

    List<PartDto> getRandomParts();
}
