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
import java.util.Date;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

/**
 *
 * @author william
 */
public class SchermdeelWerkplaats extends Schermdeel{
    
    TableView tabel = new TableView();
    Button nieuwTaak = new Button("Nieuwe taak inboeken");
    final ObservableList<Task> data = FXCollections.observableArrayList();
    
    public SchermdeelWerkplaats(ATD a) {
        super(a);
        
        data.addAll($.agenda);
        
        tabel.setEditable(false);
        tabel.setPlaceholder(new Label("Geen taken"));
        
        TableColumn c1 = new TableColumn("Naam");
        c1.setMinWidth(200);
        c1.setCellValueFactory(
            new PropertyValueFactory<Task,Customer>("customer")
        );
        
        TableColumn c2 = new TableColumn("Auto");
        c2.setMinWidth(100);
        c2.setCellValueFactory(
            new PropertyValueFactory<Task,Car>("car")
        );
        
        TableColumn c3 = new TableColumn("Datum");
        c3.setMinWidth(100);
        c3.setCellValueFactory(
            new PropertyValueFactory<Task,Date>("date")
        );
        
        TableColumn c4 = new TableColumn("Monteur");
        c4.setMinWidth(200);
        c4.setCellValueFactory(
            new PropertyValueFactory<Task,Employee>("employee")
        );
        
        TableColumn c5 = new TableColumn("Uren");
        c5.setMinWidth(100);
        c5.setCellValueFactory(
            new PropertyValueFactory<Task,Double>("hours")
        );
        
        TableColumn c6 = new TableColumn("Type");
        c6.setMinWidth(400);
        c6.setCellValueFactory(
            new PropertyValueFactory<Task,TaskType>("type")
        );
        
        TableColumn<Task, Task> col_action = new TableColumn<>("Acties");
        
        col_action.setMinWidth(140);
        
        col_action.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Task, Task>, ObservableValue<Task>>() {
            @Override public ObservableValue<Task> call(TableColumn.CellDataFeatures<Task, Task> features) {
                return new ReadOnlyObjectWrapper(features.getValue());
            }
        });
        
        col_action.setCellFactory(new Callback<TableColumn<Task, Task>, TableCell<Task, Task>>() {
            public TableCell<Task, Task> call(TableColumn<Task, Task> btnCol) {
                return new TableCell<Task, Task>() {
                
                    Button button = new Button("Uitboeken");
                    
                    public void updateItem(final Task taak, boolean empty) {
                        super.updateItem(taak, empty);
                        if (taak != null) {
                          setGraphic(button);
                          
                          button.setMinWidth(130);
                          
                            if(taak.getDone()){
                                button.setDisable(true);
                            }

                            button.setOnAction(new EventHandler<ActionEvent>() {
                                @Override public void handle(ActionEvent event) {
                                    System.out.println(taak.getCar() + " " +taak.toString());
                                }
                            });
                        } 
                        else{
                            setGraphic(null);
                        }
                    }
                };
            }
        });
        
        tabel.getColumns().addAll(c1, c2, c3, c4, c5, c6, col_action);
        tabel.setItems(data);
        
        setCenter(tabel);
        setBottom(nieuwTaak);
        
    }
    
}
