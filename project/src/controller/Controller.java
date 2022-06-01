package controller;

import model.account.Customer;
import model.account.TotalPrize;
import model.furniture.Warehouse;
import model.Main;
import javafx.fxml.FXML;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * This class is a controller of "MainPage.fxml".
 */
public class Controller {

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    /**
     * This method change scene to Admin Page.
     * @param actionEvent Action Event
     * @throws IOException IOException  If an input or output.
     */

    public void handleButtonAction(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/AdminPage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method change scene to Shop Menu Page.
     * After clicking on the button "button2" new customer will be creating with
     * new shopping cart. Customer will be add to the array list of customers.
     * @param actionEvent Action Event
     * @throws IOException IOException  If an input or output.
     */

    public void handleButtonAction2(javafx.event.ActionEvent actionEvent) throws IOException {
            Main.countOfCustomers++;
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("../view/fxml/ShopMenu.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

            Customer c = new Customer();
            c.createAddress();
            c.createShoppingcart();
            Main.customers.add(c);
            Main.customers.get(Main.countOfCustomers  - 1).getShoppingCart().attach(new TotalPrize());
            Warehouse.countEben = Warehouse.hashMap.get("Eben");
            Warehouse.countOak = Warehouse.hashMap.get("Oak");
            Warehouse.countSpruce = Warehouse.hashMap.get("Spruce");
    }
}
