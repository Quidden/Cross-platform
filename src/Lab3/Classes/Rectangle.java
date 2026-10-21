package Lab3.Classes;

public class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(String name, String color, double length, double width) {
        super(name, color);
        this.length = requirePositive(length, "Length");
        this.width = requirePositive(width, "Width");
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    public void setLength(double length) {
        this.length = requirePositive(length, "Length");
    }

    public void setWidth(double width) {
        this.width = requirePositive(width, "Width");
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }
}
