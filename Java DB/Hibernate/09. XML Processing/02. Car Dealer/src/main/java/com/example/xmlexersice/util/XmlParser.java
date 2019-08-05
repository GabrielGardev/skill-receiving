package com.example.xmlexersice.util;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface XmlParser {

    <O> O parseXml(Class<O> objectClass, String filePath) throws JAXBException, FileNotFoundException;

    <O> void exportToXml(O object, String path) throws JAXBException;
}