package Lab3.Classes;

public abstract class Shape {
    private String name;
    private String color;

    public Shape(String name, String color) {
        this.name = requireText(name, "Name");
        this.color = requireText(color, "Color");
    }

    public abstract double calculateArea();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = requireText(name, "Name");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = requireText(color, "Color");
    }

    protected static double requirePositive(double value, String fieldName) {
        if (!Double.isFinite(value) || value <= 0) {
            throw new IllegalArgumentException(fieldName + " must be a finite number greater than zero");
        }
        return value;
    }

    private static String requireText(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " must not be blank");
        }
        return value.trim();
    }

    @Override
    public String toString() {
        return name + " (" + color + ")";
    }
}
