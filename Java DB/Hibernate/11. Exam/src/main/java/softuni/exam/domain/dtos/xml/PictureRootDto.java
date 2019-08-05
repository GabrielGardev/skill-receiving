package softuni.exam.domain.dtos.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "pictures")
@XmlAccessorType(XmlAccessType.FIELD)
public class PictureRootDto {

    @XmlElement(name = "picture")
    private PictureDto[] pictures;

    public PictureDto[] getPictures() {
        return pictures;
    }

    public void setPictures(PictureDto[] pictures) {
        this.pictures = pictures;
    }
}
