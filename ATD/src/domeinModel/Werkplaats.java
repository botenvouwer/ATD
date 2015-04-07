/*
 * Studie product
 * Bestand gemaakt voor studie product. Kopieren en aanpassen is toegestaan.
 * Het is niet de bedoeling dit bestand te gebruiken voor je eiegen school opdracht.
 */
package domeinModel;

import java.io.BufferedReader;
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

        agenda.add(r);
    }

    public void load() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employees.obj"));
        employees = (ArrayList<Employee>) ois.readObject();

        ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("customers.obj"));
        customers = (Map<Integer, Customer>) (ArrayList<Employee>) ois2.readObject();

        ObjectInputStream ois3 = new ObjectInputStream(new FileInputStream("stock.obj"));
        stock = (Map<Integer, Article>) (ArrayList<Employee>) ois3.readObject();

        ObjectInputStream ois4 = new ObjectInputStream(new FileInputStream("agenda.obj"));
        agenda = (ArrayList<Task>) ois4.readObject();
        
        ois.close();
        ois2.close();
        ois3.close();
        ois4.close();
    }

    public void save() throws FileNotFoundException, IOException {
        ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream("employees.obj"));
        oos1.writeObject(employees);
        
        ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("customers.obj"));
        oos2.writeObject(customers);
        
        ObjectOutputStream oos3 = new ObjectOutputStream(new FileOutputStream("stock.obj"));
        oos3.writeObject(stock);
        
        ObjectOutputStream oos4 = new ObjectOutputStream(new FileOutputStream("agenda.obj"));
        oos4.writeObject(agenda);
        
        oos1.close();
        oos2.close();
        oos3.close();
        oos4.close();
        
    }

}
