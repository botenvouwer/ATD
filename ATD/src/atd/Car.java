package atd;

public class Car {
    private String licensePlate;
    private String brand;
    
    public Car(String licensePlate, String brand) {
        this.licensePlate = licensePlate;
        this.brand = brand;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
    
    public String getBrand() {
        return brand;
    }
    
    public String toString() {
        return brand + " with license plate " + licensePlate;
    }
}
