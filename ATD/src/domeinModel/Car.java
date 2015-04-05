package domeinModel;

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

    public boolean equals(Object refCar) {
        if (refCar instanceof Car && ((Car)refCar).getLicensePlate().equals(this.licensePlate)) {
            return true;
        }
        return false;
    }
}
