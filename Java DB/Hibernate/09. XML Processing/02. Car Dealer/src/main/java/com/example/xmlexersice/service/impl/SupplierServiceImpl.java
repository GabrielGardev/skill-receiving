package com.example.xmlexersice.service.impl;

import com.example.xmlexersice.domain.dtos.exportDto.localsuppliers.SupplierExportDto;
import com.example.xmlexersice.domain.dtos.exportDto.localsuppliers.SupplierExportRootDto;
import com.example.xmlexersice.domain.dtos.importDto.SupplierDto;
import com.example.xmlexersice.domain.dtos.importDto.SupplierRootDto;
import com.example.xmlexersice.domain.entities.Supplier;
import com.example.xmlexersice.repository.SupplierRepository;
import com.example.xmlexersice.service.SupplierService;
import com.example.xmlexersice.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {

    private final static String XML_SUPPLIER_FILE_PATH =
            "C:\\Users\\Freeware Sys\\Projects\\Java DB\\Hibernate\\09. XML Processing\\02. Car Dealer\\src\\main\\resources\\xml\\suppliers.xml";

    private final static String LOCAL_SUPPLIERS = "C:\\Users\\Freeware Sys\\Projects\\Java DB\\Hibernate\\" +
            "09. XML Processing\\02. Car Dealer\\src\\main\\resources\\xml\\export\\local-suppliers.xml";

    private final SupplierRepository supplierRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository, ModelMapper modelMapper, XmlParser xmlParser) {
        this.supplierRepository = supplierRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public void seedSuppliers() throws JAXBException, FileNotFoundException {

        SupplierRootDto list =  this.xmlParser.parseXml(SupplierRootDto.class, XML_SUPPLIER_FILE_PATH);

        for (SupplierDto supplierDto: list.getSupplierDtos()) {
            this.supplierRepository.saveAndFlush(this.modelMapper.map(supplierDto, Supplier.class));
        }
    }

    @Override
    public SupplierDto getRandomSupplier() {
        Random random = new Random();

        int id = random.nextInt((int) (this.supplierRepository.count()) - 1) +1 ;

        Supplier supplier = this.supplierRepository.getOne(id);
        return this.modelMapper.map(supplier,SupplierDto.class);
    }

    @Override
    public void localSuppliers() throws JAXBException {

        List<Supplier> suppliers = this.supplierRepository.getAllByImporterFalse();

        SupplierExportDto[] supplierExportDtos = this.modelMapper.map(suppliers, SupplierExportDto[].class);

        for (int i = 0; i < suppliers.size(); i++) {

            Supplier supplier = suppliers.get(i);
            SupplierExportDto supplierExportDto = supplierExportDtos[i];

            supplierExportDto.setPartsCount(supplier.getParts().size());

        }

        SupplierExportRootDto dto = new SupplierExportRootDto();
        dto.setSupplierExportDtos(supplierExportDtos);

        this.xmlParser.exportToXml(dto, LOCAL_SUPPLIERS);
    }
}
