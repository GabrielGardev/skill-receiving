package softuni.xmlexer.util;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface XmlParser {

    <T> T parseXml(Class<T> objectClass, String path) throws JAXBException, FileNotFoundException;

    <T> void exportToXml(T element, String path) throws JAXBException, FileNotFoundException;
}
