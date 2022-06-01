package controller;

import model.furniture.Warehouse;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * This class is a controller of "Warehouse.fxml".
 */
public class ControllerWarehouse {
    @FXML
    private Label oakWood;
    @FXML
    private Label spruceWood;
    @FXML
    private Label ebenWood;
    @FXML
    public Button btnBack;
    @FXML
    public Button btnOak;
    @FXML
    public Button btnSpruce;
    @FXML
    public Button btnEben;

    Parent root;

    /**
     * This method displays labels after loading the scene.
     */
    @FXML
    public void initialize(){
        ebenWood.setText("Počet ebenového dreva na sklade: " + Warehouse.hashMap.get("Eben"));
        oakWood.setText("Počet dubového dreva na sklade: " + Warehouse.hashMap.get("Oak"));
        spruceWood.setText("Počet smrekového dreva na sklade: " + Warehouse.hashMap.get("Spruce"));
    }

    /**
     * This method change scene to List of customer page.
     * @param actionEvent Action Event
     * @throws IOException IOException  If an input or output.
     */
    public void Back(javafx.event.ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../view/fxml/ListOfCustomersPage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method resupplies amount of Eben wood in warehouse.
     */
    public void eben(){
        int count = Warehouse.hashMap.get("Eben");
        count += 50;
        Warehouse.hashMap.remove("Eben");
        Warehouse.hashMap.put("Eben", count);
        ebenWood.setText("Počet ebenového dreva na sklade: " + Warehouse.hashMap.get("Eben"));
    }

    /**
     * This method resupplies amount of spruce wood in warehouse.
     */
    public void spruce(){
        int count = Warehouse.hashMap.get("Spruce");
        count += 50;
        Warehouse.hashMap.remove("Spruce");
        Warehouse.hashMap.put("Spruce", count);
        spruceWood.setText("Počet smrekového dreva na sklade: " + Warehouse.hashMap.get("Spruce"));
    }

    /**
     * This method resupplies amount of Oak wood in warehouse.
     */
    public void oak(){
        int count = Warehouse.hashMap.get("Oak");
        count += 50;
        Warehouse.hashMap.remove("Oak");
        Warehouse.hashMap.put("Oak", count);
        oakWood.setText("Počet dubového dreva na sklade: " + Warehouse.hashMap.get("Oak"));
    }
}
