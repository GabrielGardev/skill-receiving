package P04_Traffic_Lights;

public class TrafficLight {
    private States state;

    public TrafficLight(States state) {
        this.state = state;
    }

    public void changeState(){
        States result = null;

        switch (this.state){
            case RED:
                result = States.GREEN;
                break;
            case GREEN:
                result = States.YELLOW;
                break;
            case YELLOW:
                result = States.RED;
                break;
        }
        this.state = result;
    }

    public States getState() {
        return state;
    }
}
