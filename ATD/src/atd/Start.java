/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atd;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 *
 * @author william
 */
public class Start extends Pane{
    
    public Start(){
        
        Label l = new Label("Welkom dit is een startscherm");
        getChildren().add(l);
        
    }
    
}
