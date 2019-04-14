package solidLab.p02_OpenClosedPrinciple.p01_FileStream;

public abstract class Entity {
    private int length;

    private int sent;

    public int getLength() {
        return this.length;
    }

    private void setLength(int length) {
        this.length = length;
    }

    public int getSent() {
        return this.sent;
    }

    private void setSent(int sent) {
        this.sent = sent;
    }
}
