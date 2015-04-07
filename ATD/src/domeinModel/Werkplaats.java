/*
 * Studie product
 * Bestand gemaakt voor studie product. Kopieren en aanpassen is toegestaan.
 * Het is niet de bedoeling dit bestand te gebruiken voor je eiegen school opdracht.
 */
package domeinModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author william
 */
public class Werkplaats {
    
    public ArrayList<Employee> employees;
    public Map<Integer, Customer> customers;
    public Map<Integer, Article> stock;
    public ArrayList<Task> agenda;
    
    public Werkplaats(){
        //Werknemers collectie
        employees = new ArrayList<Employee>();
        employees.add(new Employee("kees"));
        employees.add(new Employee("klaas"));
        employees.add(new Employee("jan"));
        
        //klanten collectie
        customers = new HashMap<Integer, Customer>();
        
        Customer c = new Customer(customers.size()+1, "William loosman", "zate 31", "8483HG", "Urk");
        c.addCar(new Car("23-fg-34", "Audi a5"));
        c.addCar(new Car("21-fg-34", "Bentley gf66"));
        c.addCar(new Car("22-fg-34", "Alfa Romeo tigo"));
        
        customers.put(customers.size()+1, c);
        
        c = new Customer(customers.size()+1, "Nigel van hattum", "dane 22", "8736LS", "Lelystad");
        c.addCar(new Car("34-ed-37", "Citroën CX"));
        
        customers.put(customers.size()+1, c);
        
        System.out.println(customers);
        
        //voorraad collectie
        stock = new HashMap<Integer, Article>();
        stock.put(35345, new Article("TestArticle", 35345));
        stock.put(72384, new Article("Auto deur", 72384));
        stock.put(24343, new Article("Wieldopje", 24343));
        
        //taak collectie
        agenda = new ArrayList<Task>();
        
        Task r = new Task(Calendar.getInstance().getTime(), Task.TaskType.apk, c.getCar("34-ed-37"), c, employees.get(2));
        
        r.addUsedArticle(new RepairArticle(4, stock.get(35345)));
        r.addUsedArticle(new RepairArticle(4, stock.get(35345)));
        r.addUsedArticle(new RepairArticle(2, stock.get(72384)));
        agenda.add(r);
        
        r = new Task(Calendar.getInstance().getTime(), Task.TaskType.reparatie, customers.get(1).getCar("22-fg-34"), customers.get(1), employees.get(1));
        r.setHours(2.5);
        
        agenda.add(r);
    }
    
    private void load(){
        
    }
    
    public void save(){
        //save shit
    }
    
}
