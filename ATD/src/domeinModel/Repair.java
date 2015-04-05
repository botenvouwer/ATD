/*
 * Studie product
 * Bestand gemaakt voor studie product. Kopieren en aanpassen is toegestaan.
 * Het is niet de bedoeling dit bestand te gebruiken voor je eiegen school opdracht.
 */
package domeinModel;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author William
 */
public class Repair {
    
    private Date date;
    public enum RepairType {apk,reparatie}
    private RepairType type;
    private double hours;
    private boolean done;
    private Customer customer;
    private Car car;
    private Employee repairGuy;
    private ArrayList<RepairArticle> usedArticle;
    
    public Repair(Date d, RepairType t, Car car, Customer c, Employee rg){
        date = d;
        type = t;
        this.car = car;
        customer = c;
        repairGuy = rg;
    }
    
    public Date getDate(){
        return date;
    }
    
    public RepairType getType(){
        return type;
    }
    
    public Car getCar(){
        return car;
    }
    
    public Customer getCustomer(){
        return customer;
    }
    
    public Employee getEmployee(){
        return repairGuy;
    }
    
    public double getHours(){
        return hours;
    }
    
    public void setHours(Double hours){
        this.hours = hours;
    }
    
    public boolean getDone(){
        return done;
    }
    
    public void setDone(boolean d){
        this.done = d;
    }
    
    public ArrayList<RepairArticle> getUsedArticle(){
        return usedArticle;
    }
    
    public boolean addUsedArticle(RepairArticle a){
        if(!usedArticle.contains(a)){
            usedArticle.add(a);
            return true;
        }
        return false;
    }
    
    public boolean equals(Object o){
        
        if(!(o instanceof Repair)){
            return false;
        }
        
        Repair check = (Repair)o;
        
        return (date.equals(check.getDate()) && customer.equals(check.getCustomer()) && car.equals(check.getCar()));
    }
    
    public String toString(){
        return String.format("%s voor %s %s ingeplant op %s voor werknemer %s gebruikte artikelen %s", type.name(), customer, car, date, repairGuy, usedArticle.size());
    }
    
}
