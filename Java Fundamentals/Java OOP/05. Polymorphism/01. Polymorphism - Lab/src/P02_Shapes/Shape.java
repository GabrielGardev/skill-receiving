package P02_Shapes;

public abstract class Shape {
    private Double perimeter;
    private Double area;

    public Double getPerimeter() {
        return perimeter;
    }

    public void setParameter(Double parameter) {
        this.perimeter = parameter;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public abstract Double calculatePerimeter();
    public abstract Double calculateArea();
}
