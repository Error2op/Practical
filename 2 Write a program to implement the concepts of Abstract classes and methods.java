abstract class Shape {
    public abstract double area();

    public void display() {
        System.out.println("This is a shape.");
    }
}

// Concrete subclass
class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double area() {
        return length * width;
    }
}

// Concrete subclass
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5, 3);
        Circle circle = new Circle(4);

        rectangle.display();
        System.out.println("Area of rectangle: " + rectangle.area());

        circle.display();
        System.out.println("Area of circle: " + circle.area());
    }
}
