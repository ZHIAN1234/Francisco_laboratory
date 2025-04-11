
import java.util.Scanner;

class Vehicle {
    private String brand;
    private int speed;
    private String fuelType;

    public Vehicle(String brand, int speed, String fuelType) {
        this.brand = brand;
        this.speed = speed;
        this.fuelType = fuelType;
    }

    public String getBrand() {
        return brand;
    }

    public int getSpeed() {
        return speed;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Speed: " + speed + " km/h");
        System.out.println("Fuel Type: " + fuelType);
    }
}

class Car extends Vehicle {
    private int numDoors;

    public Car(String brand, int speed, String fuelType, int numDoors) {
        super(brand, speed, fuelType);
        this.numDoors = numDoors;
    }

    public int getNumDoors() {
        return numDoors;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Number of Doors: " + numDoors);
    }
}
class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    public Motorcycle(String brand, int speed, String fuelType, boolean hasSidecar) {
        super(brand, speed, fuelType);
        this.hasSidecar = hasSidecar;
    }
    public boolean hasSidecar() {
        return hasSidecar;
    }
    @Override
    public void displayInfo() {
        super.displayInfo(); 
        System.out.println("Has Sidecar: " + (hasSidecar? "Yes" : "No"));
    }
}
public class TestVehicle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Car details:");
        System.out.print("Brand: ");
        String carBrand = scanner.nextLine();
        System.out.print("Speed (km/h): ");
        int carSpeed = scanner.nextInt();
        scanner.nextLine();  
        System.out.print("Fuel Type: ");
        String carFuelType = scanner.nextLine();
        System.out.print("Number of Doors: ");
        int numDoors = scanner.nextInt();
        scanner.nextLine();
       
        Car car = new Car(carBrand, carSpeed, carFuelType, numDoors);

        System.out.println("\nEnter Motorcycle details:");
        System.out.print("Brand: ");
        String bikeBrand = scanner.nextLine();
        System.out.print("Speed (km/h): ");
        int bikeSpeed = scanner.nextInt();
        scanner.nextLine();  
        System.out.print("Fuel Type: ");
        String bikeFuelType = scanner.nextLine();
        System.out.print("Has Sidecar (true/false): ");
        boolean hasSidecar = scanner.nextBoolean();
      
        Motorcycle motorcycle = new Motorcycle(bikeBrand, bikeSpeed, bikeFuelType, hasSidecar);
       
        System.out.println("\nCar Details:");
        car.displayInfo();

        System.out.println("\nMotorcycle Details:");
        motorcycle.displayInfo();

    }
}
