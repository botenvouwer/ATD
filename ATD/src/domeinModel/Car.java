package domeinModel;

import java.io.Serializable;

public class Car implements Serializable{

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
        return brand + " : " + licensePlate;
    }

    public boolean equals(Object refCar) {
        if (refCar instanceof Car && ((Car)refCar).getLicensePlate().equals(this.licensePlate)) {
            return true;
        }
        return false;
    }
}
