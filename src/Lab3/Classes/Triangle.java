package Lab3.Classes;

public class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(String name, String color, double base, double height) {
        super(name, color);
        this.base = requirePositive(base, "Base");
        this.height = requirePositive(height, "Height");
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }

    public void setBase(double base) {
        this.base = requirePositive(base, "Base");
    }

    public double getBase() {
        return base;
    }

    public void setHeight(double height) {
        this.height = requirePositive(height, "Height");
    }

    public double getHeight() {
        return height;
    }
}
