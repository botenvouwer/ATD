package atd;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ConfirmBox extends Stage{
    
    private boolean gonogo = false;
    
    public ConfirmBox(Stage applicatie, String title, String text) {
        super(StageStyle.UTILITY);
        
        initOwner(applicatie);
        initModality(Modality.WINDOW_MODAL);
        setResizable(false);
        setTitle(title);
        
        BorderPane con = new BorderPane();
        con.getStyleClass().add("defPadding");
        
        Label message = new Label(text);
        
        con.setCenter(message);
        
        HBox box = new HBox();
        
        Button confirm = new Button("Doen");
        confirm.setOnAction(e -> {gonogo = true; hide(); });
        
        Button terug = new Button("Annuleren");
        terug.setOnAction(e -> {gonogo = false; hide(); });
        
        box.getChildren().addAll(confirm, terug);
        box.getStyleClass().addAll("defSpacing", "defPadding", "right");
        
        con.setBottom(box);
        
        Scene scene = new Scene(con);
        scene.getStylesheets().add("atd/style.css");
        setScene(scene);
        sizeToScene();
        terug.requestFocus();
    }
    
    public boolean getGonogo(){
        return gonogo;
    }
}