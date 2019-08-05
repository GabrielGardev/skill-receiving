package softuni.xmlexer.domain.dto;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersAndProductsRootDto implements Serializable {

    @XmlAttribute(name = "count")
    private Integer usersCount;

    @XmlElement(name = "user")
    private List<UserSoldProductDto> users;

    public Integer getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(Integer usersCount) {
        this.usersCount = usersCount;
    }

    public List<UserSoldProductDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserSoldProductDto> users) {
        this.users = users;
    }
}
