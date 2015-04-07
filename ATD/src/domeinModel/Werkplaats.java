/*
 * Studie product
 * Bestand gemaakt voor studie product. Kopieren en aanpassen is toegestaan.
 * Het is niet de bedoeling dit bestand te gebruiken voor je eiegen school opdracht.
 */
package domeinModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author william
 */
public class Werkplaats {

    public ArrayList<Employee> employees;
    public Map<Integer, Customer> customers;
    public Map<Integer, Article> stock;
    public ArrayList<Task> agenda;

    public Werkplaats() throws IOException, FileNotFoundException, ClassNotFoundException {
        load();
        /*employees = new ArrayList<Employee>();
        customers = new HashMap<Integer, Customer>();
        stock = new HashMap<Integer, Article>();
        agenda = new ArrayList<Task>();
        
        //Werknemers collectie
        employees.add(new Employee("kees"));
        employees.add(new Employee("klaas"));
        employees.add(new Employee("jan"));
        
        //klanten collectie
        
        Customer c = new Customer(customers.size() + 1, "William loosman", "zate 31", "8483HG", "Urk");
        c.addCar(new Car("23-fg-34", "Audi a5"));
        c.addCar(new Car("21-fg-34", "Bentley gf66"));
        c.addCar(new Car("22-fg-34", "Alfa Romeo tigo"));
        
        customers.put(customers.size() + 1, c);
        
        c = new Customer(customers.size() + 1, "Nigel van hattum", "dane 22", "8736LS", "Lelystad");
        c.addCar(new Car("34-ed-37", "Citroën CX"));
        
        customers.put(customers.size() + 1, c);
        
        System.out.println(customers);
        
        //voorraad collectie
        stock.put(35345, new Article("TestArticle", 35345));
        stock.put(72384, new Article("Auto deur", 72384));
        stock.put(24343, new Article("Wieldopje", 24343));
        
        //taak collectie
        
        Task r = new Task(Calendar.getInstance().getTime(), Task.TaskType.apk, c.getCar("34-ed-37"), c, employees.get(2));
        
        r.addUsedArticle(new RepairArticle(4, stock.get(35345)));
        r.addUsedArticle(new RepairArticle(4, stock.get(35345)));
        r.addUsedArticle(new RepairArticle(2, stock.get(72384)));
        agenda.add(r);
        
        r = new Task(Calendar.getInstance().getTime(), Task.TaskType.reparatie, customers.get(1).getCar("22-fg-34"), customers.get(1), employees.get(1));
        r.setHours(2.5);
        
        agenda.add(r);*/
    }

    public void load() throws ClassNotFoundException{
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(new FileInputStream("employees"));
            employees = (ArrayList<Employee>) ois.readObject();
            ois.close();
        } catch (IOException ex) {
            employees = new ArrayList<Employee>();
        }
        

        ObjectInputStream ois2;
        try {
            ois2 = new ObjectInputStream(new FileInputStream("customers"));
            customers = (Map<Integer, Customer>) ois2.readObject();
            ois2.close();
        } catch (IOException ex) {
            customers = new HashMap<Integer, Customer>();
        }
        

        ObjectInputStream ois3;
        try {
            ois3 = new ObjectInputStream(new FileInputStream("stock"));
            stock = (Map<Integer, Article>) ois3.readObject();
            ois3.close();
        } catch (IOException ex) {
            stock = new HashMap<Integer, Article>();
        }
        

        ObjectInputStream ois4;
        try {
            ois4 = new ObjectInputStream(new FileInputStream("agenda"));
            agenda = (ArrayList<Task>) ois4.readObject();
            ois4.close();
        } catch (IOException ex) {
            agenda = new ArrayList<Task>();
        }
        
    }

    public void save() throws FileNotFoundException, IOException {
        File employeesFile = new File("employees");
        ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream(employeesFile));
        oos1.writeObject(employees);
        
        File customersFile = new File("customers");
        ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream(customersFile));
        oos2.writeObject(customers);
        
        File stockFile = new File("stock");
        ObjectOutputStream oos3 = new ObjectOutputStream(new FileOutputStream(stockFile));
        oos3.writeObject(stock);
        
        File agendaFile = new File("agenda");
        ObjectOutputStream oos4 = new ObjectOutputStream(new FileOutputStream(agendaFile));
        oos4.writeObject(agenda);
        
        oos1.close();
        oos2.close();
        oos3.close();
        oos4.close();
        
    }

}
