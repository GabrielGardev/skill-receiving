package alararestaurant.util;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface XmlParser {

    <T> T parseXml(Class<T> objectClass, String path) throws JAXBException, FileNotFoundException;

}
