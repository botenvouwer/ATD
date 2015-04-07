/*
 * Studie product
 * Bestand gemaakt voor studie product. Kopieren en aanpassen is toegestaan.
 * Het is niet de bedoeling dit bestand te gebruiken voor je eiegen school opdracht.
 */
package atd;

import domeinModel.Customer;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Nigel
 */
public class AddCustomerForm extends Stage{
    private ATD app;
    private TextField nameI, adressI, zipcodeI, placeI;
    private Label nameL, nameE, adressL, adressE, zipcodeL, zipcodeE, placeL, placeE;
    private Button akkoord;
    
    public AddCustomerForm(ATD applicatie) {
        super(StageStyle.UTILITY);
        app = applicatie;
        initOwner(applicatie.stage);
        initModality(Modality.WINDOW_MODAL);
        setTitle("Klant toevoegen");

        BorderPane wrapper = new BorderPane();
        setResizable(false);
        
        VBox innerWrap = new VBox();
        innerWrap.getStyleClass().add("Vbox");
        
        HBox colum1 = new HBox();
        VBox row1 = new VBox();
        row1.setMinWidth(150);
        nameL = new Label("Naam: ");
        nameL.setMinWidth(150);
        nameE = new Label("");
        nameI = new TextField();
        row1.getChildren().addAll(nameI,nameE);
        colum1.getChildren().addAll(nameL, row1);
        
        HBox colum2 = new HBox();
        VBox row2 = new VBox();
        row2.setMinWidth(150);
        adressL = new Label("Straat en huisnummer: ");
        adressL.setMinWidth(150);
        adressE = new Label("");
        adressI = new TextField();
        row2.getChildren().addAll(adressI,adressE);
        colum2.getChildren().addAll(adressL, row2);
        
        HBox colum3 = new HBox();
        VBox row3 = new VBox();
        row3.setMinWidth(150);
        zipcodeL = new Label("Postcode: ");
        zipcodeL.setMinWidth(150);
        zipcodeE = new Label("");
        zipcodeI = new TextField();
        row3.getChildren().addAll(zipcodeI,zipcodeE);
        colum3.getChildren().addAll(zipcodeL, row3);
        
        HBox colum4 = new HBox();
        VBox row4 = new VBox();
        row4.setMinWidth(150);
        placeL = new Label("Plaats: ");
        placeL.setMinWidth(150);
        placeE = new Label("");
        placeI = new TextField();
        row4.getChildren().addAll(placeI,placeE);
        colum4.getChildren().addAll(placeL, row4);
        
        innerWrap.getChildren().addAll(colum1, colum2, colum3, colum4);
        wrapper.setCenter(innerWrap);
        
        Button akkoord = new Button("Akkoord");
        
        akkoord.setOnAction(e -> {
            if(controle()) {
                Customer k = new Customer((app.$.customers.size()+1),nameI.getText(), adressI.getText(),zipcodeI.getText(),placeI.getText());
                if(!app.$.customers.containsValue(k)) {
                    app.$.customers.put(k.getNumber(), k);
                    app.setKlanten();
                    hide();
                } else {
                    nameE.setText("Klant bestaat al!");
                    adressE.setText("Klant bestaat al!");
                    zipcodeE.setText("Klant bestaat al!");
                    placeE.setText("Klant bestaat al!");
                }
            }
        });      
        
        wrapper.setBottom(akkoord);
        Scene scene = new Scene(wrapper);
        setScene(scene);
        scene.getStylesheets().add("atd/style.css");
        sizeToScene();
        
    }

    private boolean controle() {
        boolean name = false;
        boolean adress = false;
        boolean zipcode = false;
        boolean place = false;
        
        
        if(nameI.getText() == null || nameI.getText().equals("")) {
            nameE.setText("Je moet een naam opgeven!");
        } else {
            nameE.setText("");
            name = true;
        } 
        
        if(adressI.getText().equals("")) {
            adressE.setText("Je moet een adres opgeven!");
        } else {
            adressE.setText("");
            adress = true;
        }
        
        if(zipcodeI.getText().equals("")) {
            zipcodeE.setText("Je moet een postcode opgeven!");
        } else {
            zipcodeE.setText("");
            zipcode = true;
        }
        
        if(placeI.getText().equals("")) {
            placeE.setText("Je moet een naam opgeven!");
        } else {
            placeE.setText("");
            place = true;
        }
        
        if(name && adress && zipcode && place) {
            return true;
        } else {
            return false;
        }
        
    }
}