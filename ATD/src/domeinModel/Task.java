/*
 * Studie product
 * Bestand gemaakt voor studie product. Kopieren en aanpassen is toegestaan.
 * Het is niet de bedoeling dit bestand te gebruiken voor je eiegen school opdracht.
 */
package domeinModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author William
 */
public class Task {
    
    private Date date;
    public enum TaskType {apk,reparatie}
    private TaskType type;
    private double hours;
    private boolean done;
    private Customer customer;
    private Car car;
    private Employee repairGuy;
    private ArrayList<RepairArticle> usedArticle = new ArrayList<RepairArticle>();
    
    public Task(Date d, TaskType t, Car car, Customer c, Employee rg){
        date = d;
        type = t;
        this.car = car;
        customer = c;
        repairGuy = rg;
    }
    
    public Date getDate(){
        return date;
    }
    
    public String getStringDate(){
        return new SimpleDateFormat("dd-MM-yyyy").format(date);
    }
    
    public TaskType getType(){
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
        
        if(!(o instanceof Task)){
            return false;
        }
        
        Task check = (Task)o;
        
        return (date.equals(check.getDate()) && customer.equals(check.getCustomer()) && car.equals(check.getCar()));
    }
    
    public String toString(){
        
        String usedArticles = "";
        for(RepairArticle a : usedArticle){
            usedArticles += "  - "+a.getQuantity()+" "+a.getArticle()+ "\n";
        }
        
        return String.format("%s voor %s \n for his car: %s ingeplant op %s voor werknemer %s \n\n gebruikte artikelen: \n\n %s", type.name(), customer, car, date, repairGuy, usedArticles);
    }
    
}
