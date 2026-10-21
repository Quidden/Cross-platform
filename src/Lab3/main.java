package Lab3;
import Lab3.Classes.Circle;
import Lab3.Classes.Rectangle;
import Lab3.Classes.Shape;
import Lab3.Classes.Triangle;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        int count = 0;
        int lineNumber = 0;

        String inputPath = "src/Lab3/input.txt";
        String outputPath = "src/Lab3/output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(";", -1);
                for (int i = 0; i < data.length; i++) {
                    data[i] = data[i].trim();
                }

                Shape figure;
                switch (data[0]) {
                    case "Circle":
                        checkFieldCount(data, 4);
                        figure = new Circle(
                                data[1], data[2],
                                Double.parseDouble(data[3])
                        );
                        break;

                    case "Rectangle":
                        checkFieldCount(data, 5);
                        figure = new Rectangle(
                                data[1], data[2],
                                Double.parseDouble(data[3]),
                                Double.parseDouble(data[4])
                        );
                        break;

                    case "Triangle":
                        checkFieldCount(data, 5);
                        figure = new Triangle(
                                data[1], data[2],
                                Double.parseDouble(data[3]),
                                Double.parseDouble(data[4])
                        );
                        break;

                    default:
                        throw new IllegalArgumentException("Unknown shape type: " + data[0]);
                }

                if (count == shapes.length) {
                    shapes = Arrays.copyOf(shapes, shapes.length + 1);
                }
                shapes[count] = figure;
                count++;
            }
        } catch (IOException e) {
            System.err.println("Cannot read input file: " + inputPath);
            return;
        } catch (NumberFormatException e) {
            System.err.println("Line " + lineNumber + ": invalid number format.");
            return;
        } catch (IllegalArgumentException e) {
            System.err.println("Line " + lineNumber + ": " + e.getMessage());
            return;
        }

        StringBuilder report = new StringBuilder();
        Shape largest = null;

        for (int i = 0; i < count; i++) {
            Shape fig = shapes[i];
            double area = fig.calculateArea();

            report.append(fig)
                    .append(", area: ").append(area)
                    .append(System.lineSeparator());

            if (largest == null || area > largest.calculateArea()) {
                largest = fig;
            }
        }

        if (largest != null) {
            report.append(System.lineSeparator()).append("Largest: ")
                    .append(largest.getName())
                    .append(", area: ")
                    .append(largest.calculateArea())
                    .append(System.lineSeparator());
        } else {
            report.append("No shapes found.").append(System.lineSeparator());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            writer.write(report.toString());
        } catch (IOException e) {
            System.err.println("Cannot write output file: " + outputPath);
        }
    }

    private static void checkFieldCount(String[] data, int expected) {
        if (data.length != expected) {
            throw new IllegalArgumentException(
                    "Expected " + expected + " fields for " + data[0] + ", got " + data.length
            );
        }
    }
}
