/*
 * Studie product
 * Bestand gemaakt voor studie product. Kopieren en aanpassen is toegestaan.
 * Het is niet de bedoeling dit bestand te gebruiken voor je eiegen school opdracht.
 */
package atd;

import domeinModel.Car;
import domeinModel.Employee;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Nigel
 */
public class SchermdeelAutoLijst extends Schermdeel{
    private ArrayList<Car> carList; 
    private Button ok = new Button("Voeg toe");
    private TextField licenseI = new TextField();
    private TextField brandI = new TextField();
    private Label licenseL = new Label("Kenteken: ");
    private Label brandL = new Label("Merk: ");
    
    public SchermdeelAutoLijst(ATD a, ArrayList<Car> carList) {
        super(a);
        this.carList = carList;
        
        VBox b = new VBox();
        
        for(Car e : carList){
            b.getChildren().add(new Label(e.toString()));
        }
        
        ScrollPane sp = new ScrollPane();
        sp.setStyle("-fx-margin:10;");
        sp.setFitToWidth(true);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setContent(b);
        
        ok.setOnAction(e -> {
            if(!brandI.getText().equals("")){
                Car w = new Car(licenseI.getText(), brandI.getText());
                if(!carList.contains(w)) {
                    carList.add(w);  
                }
                }
                app.setKlanten();
            });
        
        VBox texts = new VBox();
        texts.getChildren().addAll(brandI, licenseI);
        VBox labels = new VBox();
        labels.getChildren().addAll(brandL, licenseL);
        setBottom(new HBox(labels, texts, ok));
        setCenter(sp);
        
    
    }
    
}
