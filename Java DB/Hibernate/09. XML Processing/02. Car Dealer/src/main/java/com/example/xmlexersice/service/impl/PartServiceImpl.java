package com.example.xmlexersice.service.impl;

import com.example.xmlexersice.domain.dtos.importDto.PartDto;
import com.example.xmlexersice.domain.dtos.importDto.PartRootDto;
import com.example.xmlexersice.domain.entities.Part;
import com.example.xmlexersice.repository.PartRepository;
import com.example.xmlexersice.service.PartService;
import com.example.xmlexersice.service.SupplierService;
import com.example.xmlexersice.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class PartServiceImpl implements PartService {

    private final static String XML_PART_FILE_PATH =
            "C:\\Users\\Freeware Sys\\Projects\\Java DB\\Hibernate\\09. XML Processing\\02. Car Dealer\\src\\main\\resources\\xml\\parts.xml";

    private final PartRepository partRepository;
    private final ModelMapper modelMapper;
    private final SupplierService supplierService;
    private final XmlParser xmlParser;

    @Autowired
    public PartServiceImpl(PartRepository partRepository, ModelMapper modelMapper, SupplierService supplierService, XmlParser xmlParser) {
        this.partRepository = partRepository;
        this.modelMapper = modelMapper;
        this.supplierService = supplierService;
        this.xmlParser = xmlParser;
    }

    @Override
    public void seedParts() throws JAXBException, FileNotFoundException {
        PartRootDto list = this.xmlParser.parseXml(PartRootDto.class, XML_PART_FILE_PATH);

        for (PartDto partDto: list.getPartDtos()) {
            partDto.setSupplierDto(this.supplierService.getRandomSupplier());

            this.partRepository.saveAndFlush(this.modelMapper.map(partDto,Part.class));
        }
    }

    @Override
    public List<PartDto> getRandomParts() {
        List<PartDto> partDtos = new ArrayList<>();

        Random random = new Random();

        int size = random.nextInt(10) + 10;

        for (int i = 0; i < size ; i++) {
            int id = random.nextInt((int) (this.partRepository.count()) - 1) + 1;
            PartDto part = this.modelMapper.map(this.partRepository.getOne(id),PartDto.class);
            part.setSupplierDto(this.supplierService.getRandomSupplier());

            partDtos.add(part);
        }

        return partDtos;
    }
}
