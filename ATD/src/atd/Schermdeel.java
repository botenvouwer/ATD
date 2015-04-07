/*  
 * Studie product
 * Bestand gemaakt voor studie product. Kopieren en aanpassen is toegestaan.
 * Het is niet de bedoeling dit bestand te gebruiken voor je eiegen school opdracht.
 */
package atd;

import domeinModel.Werkplaats;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author william
 */
public abstract class Schermdeel extends BorderPane{
    
    ATD app;
    Werkplaats $;
    
    public Schermdeel(ATD a){
        app = a;
        $ = a.$;
        getStyleClass().add("schermdeel");
    }
    
}
