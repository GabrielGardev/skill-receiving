package softuni.exam.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class XmlParserImpl implements XmlParser {

    @Override
    public <T> T parseXml(Class<T> objectClass, String path) throws JAXBException, FileNotFoundException {

        JAXBContext context = JAXBContext.newInstance(objectClass);
        BufferedReader reader = new BufferedReader(new FileReader(new File(path)));

        Unmarshaller unmarshaller = context.createUnmarshaller();

        return (T) unmarshaller.unmarshal(reader);
    }

}
