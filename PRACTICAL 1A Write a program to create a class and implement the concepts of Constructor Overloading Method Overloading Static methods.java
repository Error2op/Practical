public class MyClass {
    private int number;

    // Constructor Overloading
    public MyClass() {
        this.number = 0;
    }

    public MyClass(int number) {
        this.number = number;
    }

    // Method Overloading
    public void printNumber() {
        System.out.println("Number: " + number);
    }

    public void printNumber(String prefix) {
        System.out.println(prefix + " Number: " + number);
    }

    // Static method
    public static void printMessage() {
        System.out.println("This is a static method.");
    }

    public static void main(String[] args) {
        MyClass obj1 = new MyClass(); // calling default constructor
        obj1.printNumber(); // calling method without parameter
        obj1.printNumber("Prefix: "); // calling method with parameter

        MyClass obj2 = new MyClass(10); // calling parameterized constructor
        obj2.printNumber(); // calling method without parameter
        obj2.printNumber("Prefix: "); // calling method with parameter

        // Calling static method using class name
        MyClass.printMessage();
    }
}
