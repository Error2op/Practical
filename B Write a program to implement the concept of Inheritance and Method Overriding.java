class Vehicle {
    String brand;
    int year;

    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    public void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Year: " + year);
    }
}

// Child class inheriting from Vehicle
class Car extends Vehicle {
    int numOfDoors;

    public Car(String brand, int year, int numOfDoors) {
        super(brand, year);
        this.numOfDoors = numOfDoors;
    }

    // Method overriding
    @Override
    public void display() {
        super.display(); // Call the display method of the parent class
        System.out.println("Number of doors: " + numOfDoors);
    }

    public static void main(String[] args) {
        // Creating an object of Car class
        Car myCar = new Car("Toyota", 2022, 4);
        myCar.display(); // Calling overridden method
    }
}
