package domeinModel;

import java.util.ArrayList;

public class Customer {

    private ArrayList<Car> cars = new ArrayList<Car>();
    private int number;
    private String name;
    private String adress;
    private String zipcode;
    private String place;

    public Customer(int number, String name, String adress, String zipcode, String place) {
        this.number = number;
        this.name = name;
        this.adress = adress;
        this.zipcode = zipcode;
        this.place = place;
    }

    public boolean addCar(Car newCar) {
        if (!cars.contains(newCar)) {
            cars.add(newCar);
            return false;
        }
        return true;
    }

    public Car getCar(String licensePlate) {
        for (Car lookingFor : cars) {
            if (lookingFor.getLicensePlate().equals(licensePlate)) {
                return lookingFor;
            }
        }
        return null;
    }

    public ArrayList<Car> getAllCars() {
        return cars;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }
    
    public void setAdres(String adress) {
        this.adress = adress;
    }

    public String getZipcode() {
        return zipcode;
    }
    
    public boolean equals(Object refCustomer) {
        
        if (refCustomer instanceof Customer && ((Customer)refCustomer).getNumber() == this.number) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "C"+number + " : " + name + " : " + place;
    }

}
