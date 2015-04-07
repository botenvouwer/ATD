/*
 * Studie product
 * Bestand gemaakt voor studie product. Kopieren en aanpassen is toegestaan.
 * Het is niet de bedoeling dit bestand te gebruiken voor je eiegen school opdracht.
 */
package atd;

import domeinModel.Car;
import domeinModel.Customer;
import domeinModel.Employee;
import domeinModel.Task;
import domeinModel.Task.TaskType;
import domeinModel.Werkplaats;
import java.time.LocalDate;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 *
 * @author william
 */
public class SchermdeelInboeken extends Schermdeel{
    
    Label klant = new Label("Klant:"), auto = new Label("Klant auto:"), taak = new Label("Taak type:"), personeel = new Label("Monteur:"), datum = new Label("Inplannen voor:");
    ComboBox<Customer> klantSelect = new ComboBox<Customer>();
    ComboBox<Car> autoSelect = new ComboBox<Car>();
    ComboBox<TaskType> taakSelect = new ComboBox<TaskType>();
    ComboBox<Employee> personeelSelect = new ComboBox<Employee>();
    DatePicker date = new DatePicker(LocalDate.now());
    Label meldingen = new Label();
    Button ok = new Button("Inboeken");
    
    public SchermdeelInboeken(ATD a){
        super(a);
        
        if($.customers.size() == 0){
            meldingen.setText("Er zijn geen klanten. Ga naar klanten beheer en voeg een klant toe. Zonder klant kun je geen taak aanmaken.");
            return;
        }
        else if($.employees.size() == 0){
            meldingen.setText("Er zijn geen werknemers. Ga naar werknemer beheer en voeg een klant toe. Zonder werknemers kun je geen taak aanmaken.");
            return;
        }
        
        VBox parent = new VBox();
        parent.getStyleClass().addAll("defSpacing", "defPadding");
        
        klantSelect.getItems().addAll($.customers.values());
        Customer c = (Customer)$.customers.values().toArray()[0];
        klantSelect.setValue(c);
        setCar(c);
        klantSelect.setOnAction(e -> setCar(klantSelect.getValue()));
        
        taakSelect.getItems().addAll(TaskType.values());
        taakSelect.setValue(TaskType.apk);
        
        personeelSelect.getItems().addAll($.employees);
        personeelSelect.setValue((Employee)$.employees.get(0));
        
        ok.setOnAction(e -> opslaan());
        
        parent.getChildren().addAll(meldingen, klant, klantSelect, auto, autoSelect, taak, taakSelect, personeel, personeelSelect, datum, date, ok);
        
        setCenter(parent);
        getStyleClass().add("center");
        
        
    }
    
    public void setCar(Customer c){
        autoSelect.getItems().clear();
        autoSelect.getItems().addAll(c.getAllCars());
        
        if(c.getAllCars().size() == 0){
            meldingen.setText("Deze klant heeft nog auto's voeg deze toe in klant beheer");
        }
        else{
            autoSelect.setValue(c.getAllCars().get(0));
        }
        
    }
    
    public void opslaan(){
        
        if(autoSelect.getValue() == null){
            meldingen.setText("Geen auto voor klant geselecteerd");
            return;
        }
        
        Task t = new Task(date.getValue(), taakSelect.getValue(), autoSelect.getValue(), klantSelect.getValue(), personeelSelect.getValue());
        $.agenda.add(t);
        
        app.setWerkplaats();
    }
    
}
