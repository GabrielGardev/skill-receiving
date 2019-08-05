package softuni.exam.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dtos.xml.PictureDto;
import softuni.exam.domain.dtos.xml.PictureRootDto;
import softuni.exam.domain.entities.Picture;
import softuni.exam.repository.PictureRepository;
import softuni.exam.util.FileUtil;
import softuni.exam.util.ValidatorUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public class PictureServiceImpl implements PictureService {

    private final static String PICTURES_FILE_PATH = System.getProperty("user.dir") + "\\src\\main\\resources\\files\\xml\\pictures.xml";

    private final PictureRepository pictureRepository;
    private final FileUtil fileUtil;
    private final XmlParser xmlParser;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper mapper;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository, FileUtil fileUtil, XmlParser xmlParser, ValidatorUtil validatorUtil, ModelMapper mapper) {
        this.pictureRepository = pictureRepository;
        this.fileUtil = fileUtil;
        this.xmlParser = xmlParser;
        this.validatorUtil = validatorUtil;
        this.mapper = mapper;
    }

    @Override
    public String importPictures() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        PictureRootDto pictureRootDto = xmlParser.parseXml(PictureRootDto.class, PICTURES_FILE_PATH);
        for (PictureDto dto : pictureRootDto.getPictures()) {
            Picture picture = mapper.map(dto, Picture.class);
            if (!this.validatorUtil.isValid(picture)) {
                sb.append("Invalid picture").append(System.lineSeparator());
                continue;
            }

            pictureRepository.saveAndFlush(picture);
            sb.append("Successfully imported picture - ").append(picture.getUrl()).append(System.lineSeparator());
        }


        return sb.toString().trim();
    }

    @Override
    public boolean areImported() {
        return pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesXmlFile() throws IOException {
        return fileUtil.readFile(PICTURES_FILE_PATH);
    }

}
