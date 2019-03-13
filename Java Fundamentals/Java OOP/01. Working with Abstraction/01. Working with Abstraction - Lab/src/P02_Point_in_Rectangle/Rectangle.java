package P02_Point_in_Rectangle;

public class Rectangle {
    private Point topLeft;
    private Point botRight;

    public Rectangle(Point topLeft, Point botRight) {
        this.topLeft = topLeft;
        this.botRight = botRight;
    }

    public boolean Contains(Point point){
        return this.topLeft.getX() <= point.getX() &&  this.topLeft.getY() <= point.getY()
                && this.botRight.getX() >= point.getX() && this.botRight.getY() >= point.getY();
    }
}
