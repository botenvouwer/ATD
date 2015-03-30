package atd;

import java.util.ArrayList;

public class Customer {
    private ArrayList<Car> allCars = new ArrayList<Car>();
    private int number;
    private String name;
    private String adress;
    private String zipcode;
    private String place;
    
    public Customer(int number, String adress, String name, String zipcode, String place) {
        this.number = number;
        this.name = name;
        this.adress = adress;
        this.zipcode = zipcode;
        this.place = place;
    }
    
    public void addCar(Car newCar) {
        if(!allCars.contains(newCar)) {
            allCars.add(newCar);
        }
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
    
    public String getZipcode() {
        return zipcode;
    }
    
    
    
    
    
}
