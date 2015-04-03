/*
 * Studie product
 * Bestand gemaakt voor studie product. Kopieren en aanpassen is toegestaan.
 * Het is niet de bedoeling dit bestand te gebruiken voor je eiegen school opdracht.
 */
package atd;

import domeinModel.Article;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Geimplemeteert vanuit subproject voorraadbeheer
 * @author william
 */
public class SchermdeelVoorraadBeheer extends BorderPane{
    
    private Stage applicatie;
    private Stock voorraad;
    private VBox records;
    
    public SchermdeelVoorraadBeheer(Stage app, Stock s){
        
        applicatie = app;
        voorraad = s;
        
        //Voorraad overzicht
        ScrollPane container = new ScrollPane();
        container.setFitToWidth(true);
        container.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        
        records = new VBox();
        records.getStyleClass().add("recordContainer");
        
        setRecords();
        
        container.setContent(records);
        
        Button toevoegen = new Button("Artikel toevoegen");
        toevoegen.setOnAction(e -> toevoegen());
        
        HBox controls = new HBox();
        controls.getChildren().addAll(toevoegen);
        controls.getStyleClass().add("control");
        
        BorderPane pane = new BorderPane();
        pane.setCenter(container);
        pane.setBottom(controls);
    }
    
     public void setRecords(){
        /*
        records.getChildren().clear();
        BorderPane[] record = new BorderPane[voorraad.size()];
        int index = 0;
        for(BorderPane b : record){
            
            Artikel a = voorraad.get(index);
            
            b = new BorderPane();
            
            Label artikelNummer = new Label("A"+a.getNummer());
            artikelNummer.getStyleClass().add("artikelNummer");
            Label artikelNaam = new Label(a.getNaam());
            artikelNaam.getStyleClass().add("artikelNaam");
            Label artikelAantal = new Label(""+a.getVoorraad());
            artikelAantal.getStyleClass().add("artikelAantal");
            artikelAantal.setPrefWidth(100);
            
            Button muteer = new Button("Muteer");
            muteer.setOnAction(e -> muteren(a));
            
            Button verwijderen = new Button("Verwijderen");
            verwijderen.setOnAction(e -> verwijderen(a));
            
            HBox artikelInfo = new HBox();
            artikelInfo.getChildren().addAll(artikelNummer, artikelNaam);
            artikelInfo.getStyleClass().add("artikelInfo");
            
            artikelInfo.setMinWidth(500);
            
            HBox buttons = new HBox();
            buttons.getChildren().addAll(muteer, verwijderen);
            buttons.getStyleClass().add("defSpacing");
            
            b.setLeft(artikelInfo);
            b.setCenter(artikelAantal);
            b.setRight(buttons);
            b.getStyleClass().add("record");
            
            records.getChildren().add(b);
            index++;
         
         }
         */
    }
    
    public void toevoegen(){
        //ArtikelForm form = new ArtikelForm(applicatie, voorraad);
        //form.showAndWait();
        //setRecords();
    }
    
    public void verwijderen(Article a){
        /*
        ConfirmBox confirm = new ConfirmBox(applicatie, "Verwijderen", "Weet u zeker dat u A"+a.getNummer()+ " "+a.getNaam()+ " wild verwijderen?");
        confirm.showAndWait();
        
        if(confirm.getGonogo()){
            voorraad.remove(a);
            setRecords();
        }
        */
    }
    
    public void muteren(Article a){
        /*
        MuteerForm form = new MuteerForm(applicatie, a);
        form.showAndWait();
        setRecords();
        */
    }
    
}
