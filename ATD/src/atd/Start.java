/*
 * Start schermdeel
 */
package atd;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author william
 */
public class Start extends Pane{
    
    public Start(){
        
        Label l = new Label("Welkom in onze applicatie kies in het menu links welk schermdeel u wildt gebruiken.");
        l.getStyleClass().add("center");
        
        BorderPane p = new BorderPane();
        p.setCenter(l);
        getChildren().add(p);
        
    }
    
}
