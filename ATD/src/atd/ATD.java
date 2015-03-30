/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atd;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author william
 */
public class ATD extends Application {
    
    private BorderPane mainScreen = new BorderPane();
    
    //main classes we use
    private Stock stock;
    private Customers customers;
    //Invoices invoiceList;
    //Repairs repairList
    
    //file names of stored data
    private String stockFile = "stock.obj";
    private String customerFile = "cust.obj";
    //String repairFile = "stock.obj":
    
    public void start(Stage stage) {
        
        load(); //load stored data
        
        VBox menu = new VBox();
        
        Button start = new Button("start");
        Button voorraad = new Button("voorraadbeheer");
        Button klanten = new Button("klantenbeheer");
        Button werk = new Button("werkplaats");
        
        menu.getChildren().addAll(start, voorraad, klanten, werk);
        
        mainScreen.setLeft(menu);
        mainScreen.setCenter(new Start());
        
        Scene scene = new Scene(mainScreen);
        scene.getStylesheets().add("atd/style.css");
        
        stage.setTitle("Auto Totaal Dienst");
        stage.sizeToScene();
        stage.getIcons().add(new Image("atd/icon.png"));
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(e -> save()); // save data
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    private void save(){
        //todo: save all data on close
    }
    
    private void load(){
        //todo: save all data on start
    }
    
}
