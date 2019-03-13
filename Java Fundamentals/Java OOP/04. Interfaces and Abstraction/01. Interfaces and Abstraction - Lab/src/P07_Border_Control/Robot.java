package P07_Border_Control;

public class Robot implements Identifiable{
    private String id;
    private String model;

    Robot(String id, String model) {
        this.setModel(model);
        this.setId(id);
    }

    private void setId(String id) {
        this.id = id;
    }

    private void setModel(String model) {
        this.model = model;
    }

    private String getModel() {
        return this.model;
    }

    @Override
    public String getId() {
        return this.id;
    }

}
