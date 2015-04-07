/*
 * Studie product
 * Bestand gemaakt voor studie product. Kopieren en aanpassen is toegestaan.
 * Het is niet de bedoeling dit bestand te gebruiken voor je eiegen school opdracht.
 */
package atd;

import domeinModel.Article;
import domeinModel.Customer;
import domeinModel.Task;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * @author william
 */
public class SchermdeelVoorraadBeheer extends Schermdeel{
    
    TableView tabel = new TableView();
    final ObservableList<Article> data = FXCollections.observableArrayList();
    Button nieuwArtikel = new Button("Artikel toevoegen");
    
    public SchermdeelVoorraadBeheer(ATD app){
        super(app);
        
        data.addAll($.stock.values());
        
        tabel.setEditable(false);
        tabel.setPlaceholder(new Label("Geen voorraad"));
        
        TableColumn c1 = new TableColumn("Nummer");
        c1.setMinWidth(200);
        c1.setCellValueFactory(
            new PropertyValueFactory<Article,Integer>("number")
        );
        
        TableColumn c2 = new TableColumn("Artikel");
        c2.setMinWidth(200);
        c2.setCellValueFactory(
            new PropertyValueFactory<Article,String>("name")
        );
        
        TableColumn c3 = new TableColumn("Voorraad");
        c3.setMinWidth(200);
        c3.setCellValueFactory(
            new PropertyValueFactory<Article,Integer>("inStock")
        );
        
        //muteer
        TableColumn<Article, Article> muteer = new TableColumn<>("Muteren");
        muteer.setMinWidth(140);
        
        muteer.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Article, Article>, ObservableValue<Article>>() {
            public ObservableValue<Article> call(TableColumn.CellDataFeatures<Article, Article> features) {
                return new ReadOnlyObjectWrapper(features.getValue());
            }
        });
        
        muteer.setCellFactory(new Callback<TableColumn<Article, Article>, TableCell<Article, Article>>() {
            public TableCell<Article, Article> call(TableColumn<Article, Article> btnCol) {
                return new TableCell<Article, Article>() {
                
                    Button button = new Button("Muteren");
                    
                    public void updateItem(final Article a, boolean empty) {
                        super.updateItem(a, empty);
                        if (a != null) {
                            setGraphic(button);
                            button.setMinWidth(130);
                            
                            button.setOnAction(new EventHandler<ActionEvent>() {
                                @Override public void handle(ActionEvent event) {
                                    
                                    FormMutate form = new FormMutate(app, a);
                                    form.showAndWait();
                                    
                                }
                            });
                        } 
                        else{
                            setGraphic(null);
                        }
                    }
                };
            }
        });
        
        //verwijder
        
        tabel.getColumns().addAll(c1, c2, c3, muteer);
        tabel.setItems(data);
        
        setCenter(tabel);
        setBottom(nieuwArtikel);
        
    }
    
    public void setRecords(){
       
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
