package entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "result_predictions")
public class ResultPrediction extends BaseEntity {
    private String prediction;

    public ResultPrediction(String prediction) {
        this.prediction = prediction;
    }

    public ResultPrediction() {
    }

    public String getPrediction() {
        return prediction;
    }

    public void setPrediction(String prediction) {
        this.prediction = prediction;
    }
}
