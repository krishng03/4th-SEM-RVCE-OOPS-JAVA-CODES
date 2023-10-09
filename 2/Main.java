import java.lang.Math;
import java.util.Scanner;

// Define the Circle class
class Circle {
    private String color;
    private double radius;

    // Constructor with radius (default color is black)
    public Circle(double radius) {
        this.radius = radius;
        this.color = "black";
    }

    // Constructor with radius and color
    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    // Getter for radius
    public double getRadius() {
        return this.radius;
    }

    // Getter for color
    public String getColor() {
        return this.color;
    }

    // Method to calculate and return the area of the circle
    public double getArea() {
        return Math.PI * (this.radius) * (this.radius);
    }
}

// Define the Cylinder class, which inherits from Circle
class Cylinder extends Circle {
    private double height;

    // Constructor with height and radius (inherits color from Circle)
    public Cylinder(double height, double radius) {
        super(radius); // Call the constructor of the superclass (Circle)
        this.height = height;
    }

    // Constructor with height, radius, and color
    public Cylinder(double height, double radius, String color) {
        super(radius, color); // Call the constructor of the superclass (Circle)
        this.height = height;
    }

    // Getter for height
    public double getHeight() {
        return this.height;
    }

    // Method to calculate and return the volume of the cylinder
    public double getVolume() {
        return (getArea()) * height;
    }

    // Method to calculate and return the total surface area of the cylinder
    public double getSurfaceArea() {
        return 2 * Math.PI * getRadius() * (getRadius() + height);
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        double height, radius;
        String color;

        Scanner sc = new Scanner(System.in);

        // Read details for Cylinder 1
        System.out.println("Read Details of Cylinder 1 :");
        System.out.print("Read Height :\n>>> ");
        height = sc.nextDouble();
        System.out.print("Read Radius :\n>>> ");
        radius = sc.nextDouble();
        sc.nextLine(); // Consume the newline character
        System.out.print("Read Color :\n>>> ");
        color = sc.nextLine();

        // Create Cylinder 1 object
        Cylinder cy1 = new Cylinder(height, radius, color);

        // Read details for Cylinder 2
        System.out.println("Read Details of Cylinder 2 :");
        System.out.print("Read Height :\n>>> ");
        height = sc.nextDouble();
        System.out.print("Read Radius :\n>>> ");
        radius = sc.nextDouble();
        sc.nextLine(); // Consume the newline character
        System.out.print("Read Color :\n>>> ");
        color = sc.nextLine();

        // Create Cylinder 2 object
        Cylinder cy2 = new Cylinder(height, radius, color);

        // Compare Cylinder 1 and Cylinder 2 properties
        if (cy1.getSurfaceArea() == cy2.getSurfaceArea() && cy1.getVolume() == cy2.getVolume() && cy1.getColor().equals(cy2.getColor())) {
            System.out.println("The Cylinders are Same!!");
            System.out.println("Cylinder Properties : ");
            System.out.println("Height\t-\t" + cy1.getHeight());
            System.out.println("Radius\t-\t" + cy1.getRadius());
            System.out.println("Color\t-\t" + cy1.getColor());
            System.out.println("Total Surface Area\t-\t" + cy1.getSurfaceArea());
            System.out.println("Volume\t-\t" + cy1.getVolume());
        } else {
            System.out.println("The Cylinders are not Same");
        }

        // Close the scanner
        sc.close();
    }
}