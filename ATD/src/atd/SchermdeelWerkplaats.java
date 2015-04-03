/*
 * Studie product
 * Bestand gemaakt voor studie product. Kopieren en aanpassen is toegestaan.
 * Het is niet de bedoeling dit bestand te gebruiken voor je eiegen school opdracht.
 */
package atd;

import javafx.beans.property.SimpleStringProperty;
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
    
    TableView tabel = new TableView();
    Button nieuwTaak = new Button("Nieuwe taak inboeken");
    final ObservableList<Person> data = FXCollections.observableArrayList(
        new Person("Jacob", "Smith", "jacob.smith@example.com"),
        new Person("Isabella", "Johnson", "isabella.johnson@example.com"),
        new Person("Ethan", "Williams", "ethan.williams@example.com"),
        new Person("Emma", "Jones", "emma.jones@example.com"),
        new Person("Michael", "Brown", "michael.brown@example.com")
    );
    
    public static class Person {
        private String firstName;
        private String lastName;
        private String email;

        private Person(String fName, String lName, String email) {
            this.firstName = new String(fName);
            this.lastName = new String(lName);
            this.email = new String(email);
        }

        public String getFirstName() {
            return firstName;
        }
        public void setFirstName(String fName) {
            firstName = fName;
        }

        public String getLastName() {
            return lastName;
        }
        public void setLastName(String fName) {
            lastName = fName;
        }

        public String getEmail() {
            return email;
        }
        public void setEmail(String fName) {
            email = fName;
        }

    }
    
    public SchermdeelWerkplaats() {
        
        tabel.setEditable(false);
        tabel.setPlaceholder(new Label("Geen taken"));
        
        TableColumn c1 = new TableColumn("test");
        TableColumn c2 = new TableColumn("pest");
        TableColumn c3 = new TableColumn("boom");
        
        c1.setCellValueFactory(
            new PropertyValueFactory<Person,String>("firstName")
        );
        c2.setCellValueFactory(
            new PropertyValueFactory<Person,String>("lastName")
        );
        c3.setCellValueFactory(
            new PropertyValueFactory<Person,String>("email")
        );
        
        tabel.getColumns().addAll(c1, c2, c3);
        tabel.setItems(data);
        
        setCenter(tabel);
        setBottom(nieuwTaak);
        
    }
    
    
    
}
