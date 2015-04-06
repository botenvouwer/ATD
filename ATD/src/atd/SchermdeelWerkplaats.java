/*
 * Studie product
 * Bestand gemaakt voor studie product. Kopieren en aanpassen is toegestaan.
 * Het is niet de bedoeling dit bestand te gebruiken voor je eiegen school opdracht.
 */
package atd;

import domeinModel.Car;
import domeinModel.Employee;
import domeinModel.Task;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author william
 */
public class SchermdeelWerkplaats extends BorderPane{
    
    //ATD moeder klasse met alle collecties etc.
    private ATD $;
    
    TableView tabel = new TableView();
    Button nieuwTaak = new Button("Nieuwe taak inboeken");
    final ObservableList<Task> data = FXCollections.observableArrayList();
    
    public SchermdeelWerkplaats(ATD a) {
        
        $ = a;
        
        data.addAll($.agenda);
        
        tabel.setEditable(false);
        tabel.setPlaceholder(new Label("Geen taken"));
        
        TableColumn c1 = new TableColumn("datum");
        c1.setMinWidth(400);
        TableColumn c2 = new TableColumn("type");
        c2.setMinWidth(100);
        TableColumn c3 = new TableColumn("uren");
        c3.setMinWidth(100);
        TableColumn c4 = new TableColumn("klaar");
        c4.setMinWidth(200);
        TableColumn c5 = new TableColumn("Werknemer");
        c5.setMinWidth(300);
        TableColumn c6= new TableColumn("Auto");
        c6.setMinWidth(400);
        
        c1.setCellValueFactory(
            new PropertyValueFactory<Task,Date>("date")
        );
        c2.setCellValueFactory(
            new PropertyValueFactory<Task,Task.TaskType>("type")
        );
        c3.setCellValueFactory(
            new PropertyValueFactory<Task,Double>("hours")
        );
        c4.setCellValueFactory(
            new PropertyValueFactory<Task,Boolean>("done")
        );
        c5.setCellValueFactory(
            new PropertyValueFactory<Task,Employee>("employee")
        );
        c6.setCellValueFactory(
            new PropertyValueFactory<Task,Car>("car")
        );
        
        tabel.getColumns().addAll(c1, c2, c3, c4, c5, c6);
        tabel.setItems(data);
        
        setCenter(tabel);
        setBottom(nieuwTaak);
        
    }
    
    
    
}
