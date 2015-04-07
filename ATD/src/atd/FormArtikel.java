package atd;

import domeinModel.Article;
import domeinModel.Werkplaats;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FormArtikel extends Stage {

    private ATD app;
    private Werkplaats $;
    private TextField naam, art;
    private Label naamE = new Label(), artE = new Label();

    public FormArtikel(ATD app) {

        super(StageStyle.UTILITY);
        this.app = app;
        this.$ = app.$;

        artE.getStyleClass().add("error");
        naamE.getStyleClass().add("error");
        initOwner(app.stage);
        initModality(Modality.WINDOW_MODAL);
        setResizable(false);
        setTitle("Artikel toevoegen");

        VBox con = new VBox();
        con.getStyleClass().addAll("defPadding", "right", "defSpacing");

        HBox artnmcon = new HBox();
        artnmcon.getStyleClass().addAll("right", "defSpacing");

        Label artL = new Label("Artikel nummer:");
        art = new TextField();

        artnmcon.getChildren().addAll(artL, art);

        HBox naamcon = new HBox();
        naamcon.getStyleClass().addAll("right", "defSpacing");

        Label naamL = new Label("Artikel naam:");
        naam = new TextField();

        naamcon.getChildren().addAll(naamL, naam);

        Button btn = new Button("Opslaan");
        btn.setOnAction(e -> opslaan());

        con.getChildren().addAll(artnmcon, artE, naamcon, naamE, btn);

        Scene scene = new Scene(con);
        scene.getStylesheets().add("atd/style.css");
        setScene(scene);
        sizeToScene();

    }

    public void opslaan() {
        try {
            int input = Integer.parseInt(art.getText());
            Article a = new Article(naam.getText(), input);
            if ($.stock.containsValue(a)) {
                artE.setText("Artikel bestaat al!");
            } else {
                $.stock.put(input, a);
                artE.setText("");
                app.setVoorraad();
                hide();
            }
        } catch (NumberFormatException e) {
            artE.setText("Voer een geldig getal in!");
        }

    }
}
