package Module2;
public class Triangle extends GeometricObject {
    private double side1 = 1, side2 = 1, side3 = 1;

    public Triangle() {}
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    
    public double getPerimeter() { return side1 + side2 + side3; }
    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
    @Override
    public String toString() {
        return "Triangle: First side = " + side1 + " Second side = " + side2 + " Third side = " + side3;
    }
}
