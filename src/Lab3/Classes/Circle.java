package Lab3.Classes;

public class Circle extends Shape {
    private double radius;

    public Circle(String name, String color, double radius) {
        super(name, color);
        this.radius = requirePositive(radius, "Radius");
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public void setRadius(double radius) {
        this.radius = requirePositive(radius, "Radius");
    }

    public double getRadius() {
        return radius;
    }
}
