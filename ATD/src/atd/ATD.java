/*
 * Begin punt van applicatie
 */
package atd;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import domeinModel.*;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author william
 */
public class ATD extends Application {
    
    public Stage stage;
    private BorderPane mainScreen = new BorderPane();
    
    /* ff overleggen
    //main classes we use
    private Stock stock;
    private Customers customers;
    //Invoices invoiceList;
    //Repairs repairList
    */
    
    //collecties
    public ArrayList<Employee> employees;
    public Map<Integer, Customer> customers;
    public Map<Integer, Article> stock;
    public ArrayList<Task> agenda;
    
    //Menu buttons
    Button start;
    Button voorraad;
    Button klanten;
    Button personeel;
    Button werk;
    
    //file names of stored data
    private String stockFile = "stock.obj";
    private String customerFile = "cust.obj";
    //String repairFile = "stock.obj":
    
    public ATD(){
         /* testcode */
        
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
    
    public void start(Stage stage) {
        this.stage = stage;
        
        load(); //load stored data
        
        VBox menu = new VBox();
        menu.getStyleClass().add("mainmenu");
        
        start = new Button("start");
        start.setOnAction(e -> setStart());
        voorraad = new Button("voorraad");
        voorraad.setOnAction(e -> setVoorraad());
        klanten = new Button("klanten");
        personeel = new Button("personeel");
        werk = new Button("werkplaats");
        werk.setOnAction(e -> setWerkplaats());
        
        menu.getChildren().addAll(start, voorraad, klanten, werk);
        
        mainScreen.setLeft(menu);
        setStart();
        
        Scene scene = new Scene(mainScreen);
        scene.getStylesheets().add("atd/style.css");
        
        stage.setTitle("Auto Totaal Dienst");
        stage.sizeToScene();
        stage.getIcons().add(new Image("atd/icon.png"));
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(e -> save()); // save data
        stage.setMinHeight(600);
        stage.setMinWidth(800);
    }
    
    public void setStart(){
        Start scherm = new Start();
        scherm.getStyleClass().add("schermdeel");
        
        mainScreen.setCenter(scherm);
    }
    
    public void setVoorraad(){
        //SchermdeelVoorraadBeheer scherm = new SchermdeelVoorraadBeheer(stage, stock);
        //scherm.getStyleClass().add("schermdeel");
        
        //mainScreen.setCenter(scherm);
    }
    
    public void setWerkplaats(){
        SchermdeelWerkplaats scherm = new SchermdeelWerkplaats(this);
        scherm.getStyleClass().add("schermdeel");
        
        mainScreen.setCenter(scherm);
    }
    
    public static void main(String[] args) {
        launch(args); 
    }
    
    private void save(){
        //todo: save all data on close
    }
    
    private void load(){
        
        
        
    }
    
    //Dit zou efficenter kunnen (Bijvoorbeeld dynamisch) maar geen tijd voor fuck het dit werkt ook
    private void loadKlanten(){
        
    }
    
    private void loadPersoneel(){
        
    }
    
}
