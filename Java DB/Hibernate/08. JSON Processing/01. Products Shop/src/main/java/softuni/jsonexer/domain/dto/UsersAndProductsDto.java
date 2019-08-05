package softuni.jsonexer.domain.dto;

import com.google.gson.annotations.Expose;

public class UsersAndProductsDto {

    @Expose
    private Integer usersCount;

    @Expose
    private UserSoldProductDto[] users;

    public Integer getUsersCount() {
        return usersCount;
    }

    public UserSoldProductDto[] getUsers() {
        return users;
    }

    public void setUsersCount(Integer usersCount) {
        this.usersCount = usersCount;
    }

    public void setUsers(UserSoldProductDto[] users) {
        this.users = users;
    }
}
