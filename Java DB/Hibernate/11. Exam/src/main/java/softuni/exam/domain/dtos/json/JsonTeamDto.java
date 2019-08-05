package softuni.exam.domain.dtos.json;

import com.google.gson.annotations.Expose;

public class JsonTeamDto {

    @Expose
    private String name;

    @Expose
    private JsonPictureDto picture;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JsonPictureDto getPicture() {
        return picture;
    }

    public void setPicture(JsonPictureDto picture) {
        this.picture = picture;
    }
}
