package meisterTask.bindingModels;

public class TaskBindingModel {

    private String status;
    private String title;

    public TaskBindingModel() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
