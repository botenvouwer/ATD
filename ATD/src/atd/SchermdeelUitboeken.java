/*
 * Studie product
 * Bestand gemaakt voor studie product. Kopieren en aanpassen is toegestaan.
 * Het is niet de bedoeling dit bestand te gebruiken voor je eiegen school opdracht.
 */
package atd;

import Exceptions.StockException;
import domeinModel.Article;
import domeinModel.Task;
import java.util.Collection;
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
public class SchermdeelUitboeken extends Schermdeel{
    
    Task task;
    Label error = new Label(), beschrijving = new Label(), urenLabel = new Label("Uren: "), noteLabel = new Label("Notitie: ");
    TextField uren = new TextField();
    TextField note = new TextField();
    StockTextField[] stockOut;
    Button ok = new Button("Uitboeken");
    
    public SchermdeelUitboeken(ATD a, Task t){
        super(a);
        task = t;
        
        VBox parent = new VBox();
        
        beschrijving.setText("Klant: " + t.getCustomer()+ " \nAuto: "+ t.getCar() + " \nType: "+ t.getType() + " \nDatum: "+ t.getDate());
        
        ScrollPane sp = new ScrollPane();
        sp.setStyle("-fx-margin:10;");
        sp.setFitToWidth(true);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setContent(artikelenUitboekenDing());
        
        error.getStyleClass().add("error");
        parent.getChildren().addAll(error, beschrijving, urenLabel, uren, noteLabel, note, new Label("Voorraad:"), sp);
        getStyleClass().addAll("defSpacing", "defPadding");
        
        ok.setOnAction(e -> opslaan());
        
        setCenter(parent);
        setBottom(ok);
        
    }
    
    public void opslaan(){
        
        double u = 0;
        
        try
        {
            u = Double.parseDouble(uren.getText());
        }
        catch(NumberFormatException e)
        {
            error.setText("Geef Uren op als Double: 1.5 = 1 uur en 30 min");
            return;
        }
        
        ConfirmBox confirm = new ConfirmBox(app.stage, "Taak uitboeken", "Wil je deze taak echt uitboeken? Je kan dit niet terug draaien!");
        confirm.showAndWait();
        
        if(!confirm.getGonogo()){
            return;
        }
        
        task.setDone(true);
        task.setHours(u);
        task.setNote(note.getText());
        
        for(StockTextField t : stockOut){
            if(!t.getText().equals("") && t.getNumber() > 0){
                try {
                    t.article.StockOut(t.getNumber());
                } catch (StockException ex) {
                    error.setText("Kan "+t.article+" niet uitboeken! Er is te weinig voorraad.");
                    return;
                }
            }
        }
        
        app.setWerkplaats();
        
    }
    
    public VBox artikelenUitboekenDing(){
        VBox b = new VBox();
        
        Collection<Article> stock = $.stock.values();
        
        stockOut = new StockTextField[stock.size()];
        
        //maak hier voorraad uitboeken dinkies
        int q = 0;
        for(Article a : stock){
            
            StockTextField t = new StockTextField(a);
            
            HBox r = new HBox();
            
            r.getChildren().addAll(new Label(a.toString()), t);
            
            b.getChildren().add(r);
            stockOut[q] = t;
            q++;
        }
        
        return b;
    }
    
}
