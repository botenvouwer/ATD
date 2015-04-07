/*
 * Studie product
 * Bestand gemaakt voor studie product. Kopieren en aanpassen is toegestaan.
 * Het is niet de bedoeling dit bestand te gebruiken voor je eiegen school opdracht.
 */
package atd;

import Exceptions.StockException;
import domeinModel.Article;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author william
 */
public class FormMutate extends Stage {

    private Article artikel;
    private TextField aantal;
    private Label aantalE;
    private ATD app;

    public FormMutate(ATD applicatie, Article artikel) {
        super(StageStyle.UTILITY);
        
        app = applicatie;
        this.artikel = artikel;
        initOwner(applicatie.stage);
        initModality(Modality.WINDOW_MODAL);
        setTitle("Voorraad muteren");

        BorderPane wrapper = new BorderPane();
        setResizable(false);

        // Bovenkant scherm.
        VBox toplane = new VBox();
        Label artikelNummer = new Label("Geselecteerd Artikel: " + artikel.getNumber()+ ", " + artikel.getName());
        Label voorraadArtikel = new Label("Huidige voorraad: " + artikel.getInStock());
        toplane.getChildren().addAll(artikelNummer, voorraadArtikel);
        toplane.getStyleClass().add("toplaneMuteer");
        wrapper.setTop(toplane);

        // Input
        VBox centerPane = new VBox();
        TextField aantal = new TextField();
        Label aantalE = new Label();
        aantalE.getStyleClass().add("error");
        centerPane.getChildren().addAll(aantal, aantalE);
        centerPane.getStyleClass().add("inputMuteer");
        wrapper.setCenter(centerPane);
        this.aantal = aantal;
        this.aantalE = aantalE;

        // Buttons
        HBox buttonWrapper = new HBox();
        Button afboeking = new Button("Uitboeken");
        afboeking.setMinWidth(75);
        afboeking.setOnAction(e -> uitboeken());
        Button telling = new Button("Geteld");
        telling.setMinWidth(75);
        telling.setOnAction(e -> geteld());
        Button inboeking = new Button("Inboeken");
        inboeking.setMinWidth(75);
        inboeking.setOnAction(e -> inboeken());
        buttonWrapper.getChildren().addAll(afboeking, telling, inboeking);
        buttonWrapper.getStyleClass().addAll("buttonsMuteer");
        wrapper.setBottom(buttonWrapper);

        Scene scene = new Scene(wrapper);
        setScene(scene);
        scene.getStylesheets().add("atd/style.css");
        sizeToScene();

    }

    public boolean geldigGetal() {
        try {
            Integer.parseInt(aantal.getText());
            aantalE.setText("");
            return true;
        } catch (NumberFormatException e) {
            aantalE.setText("Voer een geldig getal in!");
            return false;
        }
    }

    public void geteld() {
        if (geldigGetal()) {
            ConfirmBox cf = new ConfirmBox(this, "telling", "Klopt het dat de voorraad van " + artikel.getNumber() + ", " + artikel.getName() + " " + aantal.getText() + " is?");
            cf.showAndWait();
            if (cf.getGonogo()) {
                try {
                    artikel.setInStock(Integer.parseInt(aantal.getText()));
                    hide();
                    app.setVoorraad();
                } catch (StockException ex) {
                    aantalE.setText(ex.getMessage());
                }
                
            }
        }

    }

    public void inboeken() {
        if (geldigGetal()) {
            ConfirmBox cf = new ConfirmBox(this, "telling", "Klopt het dat u de voorraad van " + artikel.getNumber() + ", " + artikel.getName() + " met " + aantal.getText() + " wil verhogen?");
            cf.showAndWait();
            if (cf.getGonogo()) {
                try {
                    artikel.stockIn(Integer.parseInt(aantal.getText()));
                    hide();
                    app.setVoorraad();
                } catch (StockException ex) {
                    aantalE.setText(ex.getMessage());
                }
                
            }
        }
    }

    public void uitboeken() {
        if (geldigGetal()) {
            ConfirmBox cf = new ConfirmBox(this, "telling", "Klopt het dat u de voorraad van " + artikel.getNumber() + ", " + artikel.getName() + " met " + aantal.getText() + " wil verminderen?");
            cf.showAndWait();
            if (cf.getGonogo()) {
                try {
                    artikel.StockOut(Integer.parseInt(aantal.getText()));
                    hide();
                    app.setVoorraad();
                } catch (StockException ex) {
                    aantalE.setText(ex.getMessage());
                }
                
            }
        }

    }
}
