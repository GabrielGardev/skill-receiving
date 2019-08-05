package softuni.xmlexer.domain.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserSoldProductsWithBuyerRootDto {

    @XmlElement(name = "user")
    private List<UserSoldProductWithBuyerDto> users;

    public List<UserSoldProductWithBuyerDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserSoldProductWithBuyerDto> users) {
        this.users = users;
    }
}
