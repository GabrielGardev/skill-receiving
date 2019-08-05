package com.example.xmlexersice.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class XmlParserImpl implements XmlParser {

    @Override
    public <T> T parseXml(Class<T> objectClass, String path) throws JAXBException, FileNotFoundException {

        JAXBContext context = JAXBContext.newInstance(objectClass);
        BufferedReader reader = new BufferedReader(new FileReader(new File(path)));

        Unmarshaller unmarshaller = context.createUnmarshaller();

        return (T) unmarshaller.unmarshal(reader);
    }

    @Override
    public <O> void exportToXml(O object, String path) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(object.getClass());

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(object, new File(path));
    }
}