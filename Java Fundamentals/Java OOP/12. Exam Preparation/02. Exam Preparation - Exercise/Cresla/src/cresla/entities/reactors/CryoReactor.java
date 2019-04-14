package cresla.entities.reactors;

public class CryoReactor extends ReactorImpl {
    private int cryoProductionIndex;

    public CryoReactor(int id, int cryoProductionIndex, int capacity) {
        super(id, capacity);
        this.cryoProductionIndex = cryoProductionIndex;
    }

    @Override
    public long getTotalEnergyOutput() {
       return super.getTotalEnergyOutput() * this.cryoProductionIndex;
    }
}
