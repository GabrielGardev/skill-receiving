package P01_Class_Box;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double calculateSurfaceArea(){
        //Surface Area = 2lw + 2lh + 2wh
        return 2 * this.length * this.width + 2 * this.length * this.height + 2 * this.width * this.height;
    }

    public double calculateLateralSurfaceArea(){
        //Lateral Surface Area = 2lh + 2wh
        return 2 * this.length * this.height + 2 * this.width * this.height;
    }

    public double calculateVolume(){
        return this.length * this.width * this.height;
    }
}
