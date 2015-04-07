/*
 * Start schermdeel
 */
package atd;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author william
 */
public class Start extends BorderPane{
    
    public Start(){
        
        Label l = new Label("Welkom in onze applicatie kies in het menu links welk schermdeel u wilt gebruiken.");
        l.getStyleClass().add("center");
        
        setCenter(l);
    }
    
}
