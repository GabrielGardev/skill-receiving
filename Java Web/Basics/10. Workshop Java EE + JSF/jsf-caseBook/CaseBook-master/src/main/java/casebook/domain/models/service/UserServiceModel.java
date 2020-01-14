package casebook.domain.models.service;

import casebook.domain.entities.Gender;

import java.util.ArrayList;
import java.util.List;

public class UserServiceModel {

    private String id;
    private String username;
    private String password;
    private Gender gender;
    private List<UserServiceModel> friends;

    public UserServiceModel() {
        this.friends = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<UserServiceModel> getFriends() {
        return friends;
    }

    public void setFriends(List<UserServiceModel> friends) {
        this.friends = friends;
    }
}
