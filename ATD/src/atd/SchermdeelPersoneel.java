/*
 * Studie product
 * Bestand gemaakt voor studie product. Kopieren en aanpassen is toegestaan.
 * Het is niet de bedoeling dit bestand te gebruiken voor je eiegen school opdracht.
 */
package atd;

import domeinModel.Employee;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author william
 */
public class SchermdeelPersoneel extends Schermdeel{
    
    TextField naam = new TextField();
    Button ok = new Button("Werknemer toevoegen");
    
    public SchermdeelPersoneel(ATD a) {
        super(a);
        
        VBox b = new VBox();
        
        for(Employee e : $.employees){
            b.getChildren().add(new Label(e.toString()));
        }
        
        ScrollPane sp = new ScrollPane();
        sp.setStyle("-fx-margin:10;");
        sp.setFitToWidth(true);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setContent(b);
        
        ok.setOnAction(e -> {
            if(!naam.getText().equals("")){
                Employee w = new Employee(naam.getText());
                $.employees.add(w);
                app.setPersoneel();
            }
        });
        
        setTop(new HBox(naam, ok));
        setCenter(sp);
        
    }
    
}
