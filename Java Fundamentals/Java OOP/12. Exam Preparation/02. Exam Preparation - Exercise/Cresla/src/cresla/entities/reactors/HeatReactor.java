package cresla.entities.reactors;

public class HeatReactor extends ReactorImpl {
    private int heatReductionIndex;

    public HeatReactor(int id, int heatReductionIndex, int capacity) {
        super(id, capacity);
        this.heatReductionIndex = heatReductionIndex;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return super.getTotalHeatAbsorbing() + this.heatReductionIndex;
    }

}
