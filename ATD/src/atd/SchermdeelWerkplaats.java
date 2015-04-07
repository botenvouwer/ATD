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
        
        TableColumn c1 = new TableColumn("datum");
        c1.setMinWidth(200);
        TableColumn c2 = new TableColumn("type");
        c2.setMinWidth(100);
        TableColumn c3 = new TableColumn("uren");
        c3.setMinWidth(100);
        TableColumn c4 = new TableColumn("klaar");
        c4.setMinWidth(200);
        TableColumn c5 = new TableColumn("Werknemer");
        c5.setMinWidth(100);
        TableColumn c6= new TableColumn("Auto");
        c6.setMinWidth(400);
        
        
        TableColumn<Task, Task> col_action = new TableColumn<>("Action");
        
        col_action.setMinWidth(400);
        
        col_action.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Task, Task>, ObservableValue<Task>>() {
          @Override public ObservableValue<Task> call(TableColumn.CellDataFeatures<Task, Task> features) {
              return new ReadOnlyObjectWrapper(features.getValue());
          }
        });
        
        col_action.setCellFactory(new Callback<TableColumn<Task, Task>, TableCell<Task, Task>>() {
          @Override public TableCell<Task, Task> call(TableColumn<Task, Task> btnCol) {
            return new TableCell<Task, Task>() {
              final Button button = new Button("test"); {
                button.setMinWidth(130);
              }
              @Override public void updateItem(final Task person, boolean empty) {
                super.updateItem(person, empty);
                if (person != null) {
                  setGraphic(button);
                  button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent event) {
                      System.out.println(person.getCar() + " " +person.toString());
                    }
                  });
                } else {
                  setGraphic(null);
                }
              }
            };
          }
        });
        
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
        
        tabel.getColumns().addAll(c1, c2, c3, c4, c5, c6, col_action);
        tabel.setItems(data);
        
        setCenter(tabel);
        setBottom(nieuwTaak);
        
    }
    
}
