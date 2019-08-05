package softuni.xmlexer.domain.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryRootDto implements Serializable {

    @XmlElement(name = "category")
    private List<CategorySeedDto> categories;

    public List<CategorySeedDto> getCategories() {
        return categories;
    }

    public void setCategories(List<CategorySeedDto> categories) {
        this.categories = categories;
    }
}
