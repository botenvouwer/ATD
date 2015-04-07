/*
 * Begin punt van applicatie
 */
package atd;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import domeinModel.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author william
 */
public class ATD extends Application {
    
    public Stage stage;
    public BorderPane mainScreen = new BorderPane();
    
    //domeinmodel
    public Werkplaats $;
    
    //Menu buttons
    Button start;
    Button voorraad;
    Button klanten;
    Button personeel;
    Button werk;
    
    public ATD() {
        try {
        $ = new Werkplaats();
        } catch (IOException | ClassNotFoundException ex) {
        System.out.println("test");
        }
    }
    
    public void start(Stage stage) {
        this.stage = stage;
        
        //load(); //load stored data
        
        VBox menu = new VBox();
        menu.getStyleClass().add("mainmenu");
        
        start = new Button("start");
        start.setOnAction(e -> setStart());
        voorraad = new Button("voorraad");
        voorraad.setOnAction(e -> setVoorraad());
        klanten = new Button("klanten");
        personeel = new Button("personeel");
        werk = new Button("werkplaats");
        werk.setOnAction(e -> setWerkplaats());
        
        menu.getChildren().addAll(start, voorraad, klanten, werk);
        
        mainScreen.setLeft(menu);
        setStart();
        
        Scene scene = new Scene(mainScreen);
        scene.getStylesheets().add("atd/style.css");
        
        stage.setTitle("Auto Totaal Dienst");
        stage.getIcons().add(new Image("atd/icon.png"));
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(e -> {
            
            try {
                $.save();
            } catch (IOException ex) {
                Logger.getLogger(ATD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); // save data
        //stage.setMinHeight(600);
        //stage.setMinWidth(800);
        stage.setMaximized(true);
    }
    
    public void setStart(){
        mainScreen.setCenter(new Start());
    }
    
    public void setVoorraad(){
        mainScreen.setCenter(new SchermdeelVoorraadBeheer(this));
    }
    
    public void setWerkplaats(){
        mainScreen.setCenter(new SchermdeelWerkplaats(this));
    }
    
    public static void main(String[] args) {
        launch(args); 
    }    
}
