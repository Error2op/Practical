abstract class Shape {
    // Abstract method (does not have a body)
    public abstract double area();

    // Non-abstract method
    public void display() {
        System.out.println("This is a shape.");
    }
}

// Concrete class inheriting from the abstract class
class Rectangle extends Shape {
    double length;
    double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Implementing the abstract method
    public double area() {
        return length * width;
    }

    public static void main(String[] args) {
        // Creating an object of the Rectangle class
        Rectangle rect = new Rectangle(5, 4);
        System.out.println("Area of rectangle: " + rect.area());
        rect.display();
    }
}
