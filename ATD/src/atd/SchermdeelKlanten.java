/*
 * Studie product
 * Bestand gemaakt voor studie product. Kopieren en aanpassen is toegestaan.
 * Het is niet de bedoeling dit bestand te gebruiken voor je eiegen school opdracht.
 */
package atd;

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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

/**
 *
 * @author Nigel
 */
public class SchermdeelKlanten extends Schermdeel {

    TableView tabel = new TableView();
    Button nieuweKlant = new Button("Nieuwe klant aanmaken");
    final ObservableList<Customer> data = FXCollections.observableArrayList();

    public SchermdeelKlanten(ATD a) {
        super(a);

        data.addAll($.customers.values());
        tabel.setEditable(false);
        tabel.setPlaceholder(new Label("Geen klanten "));

        TableColumn c1 = new TableColumn("Naam");
        c1.setMinWidth(250);
        c1.setCellValueFactory(
                new PropertyValueFactory<Customer, String>("name")
        );

        TableColumn c2 = new TableColumn("Adres");
        c2.setMinWidth(250);
        c2.setCellValueFactory(
                new PropertyValueFactory<Customer, String>("adress")
        );

        TableColumn c3 = new TableColumn("Woonplaats");
        c3.setMinWidth(250);
        c3.setCellValueFactory(
                new PropertyValueFactory<Customer, String>("place")
        );

        TableColumn<Customer, Customer> carList = new TableColumn<>("Auto's");

        carList.setMinWidth(140);

        carList.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Customer, Customer>, ObservableValue<Customer>>() {
            @Override
            public ObservableValue<Customer> call(TableColumn.CellDataFeatures<Customer, Customer> features) {
                return new ReadOnlyObjectWrapper(features.getValue());
            }
        });

        carList.setCellFactory(new Callback<TableColumn<Customer, Customer>, TableCell<Customer, Customer>>() {
            @Override
            public TableCell<Customer, Customer> call(TableColumn<Customer, Customer> btnCol) {
                return new TableCell<Customer, Customer>() {

                    Button button = new Button("Auto's");

                    public void updateItem(final Customer customer, boolean empty) {
                        super.updateItem(customer, empty);
                        if (customer != null) {
                            setGraphic(button);

                            button.setMinWidth(130);

                            button.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {

                                }
                            });
                        } else {
                            setGraphic(null);
                        }
                    }
                };
            }
        });

        tabel.getColumns().addAll(c1, c2, c3, carList);
        tabel.setItems(data);
        
        
        nieuweKlant.setOnAction(e -> {
            AddCustomerForm newC = new AddCustomerForm(app);
            System.out.println("test");
            newC.showAndWait();
        });
        setCenter(tabel);
        setBottom(nieuweKlant);
       

    }
}
