package softuni.exam.domain.dtos.json;

import com.google.gson.annotations.Expose;

public class JsonPictureDto {

    @Expose
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
