/*
 * Studie product
 * Bestand gemaakt voor studie product. Kopieren en aanpassen is toegestaan.
 * Het is niet de bedoeling dit bestand te gebruiken voor je eiegen school opdracht.
 */
package domeinModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
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
        oos1.close();
        
        File customersFile = new File("customers");
        ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream(customersFile));
        oos2.writeObject(customers);
        oos2.close();
        
        File stockFile = new File("stock");
        ObjectOutputStream oos3 = new ObjectOutputStream(new FileOutputStream(stockFile));
        oos3.writeObject(stock);
        oos3.close();
        
        File agendaFile = new File("agenda");
        ObjectOutputStream oos4 = new ObjectOutputStream(new FileOutputStream(agendaFile));
        oos4.writeObject(agenda);        
    }

}
