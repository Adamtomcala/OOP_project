package controller;

import model.furniture.Warehouse;
import model.Main;
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
 * This class is a controller of "ShopMenu.fxml".
 */
public class ControllerShop {
    @FXML
    public Button stolicky;
    @FXML
    public Button spat;
    @FXML
    public Label count;
    @FXML
    private Label label1 ;
    @FXML
    public Button stoly;
    @FXML
    public Button postele;
    @FXML
    public Button skrine;

    Parent root;

    /**
     * This method changes scene to Main page.
     * @param actionEvent   Action Event.
     * @throws IOException  IOException  If an input or output.
     */
    public void handleButtonAction1(javafx.event.ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../view/fxml/MainPage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        Main.customers.remove(Main.customers.size() - 1);
        Main.countOfCustomers--;
        Warehouse.countPlanks();
    }

    /**
     * This method changes scene to Shopping cart page.
     * @param actionEvent   Action Event.
     * @throws IOException  IOException  If an input or output.
     */
    public void handleButtonAction2(javafx.event.ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../view/fxml/ShoppingCartPage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method changes scene to Chair page.
     * @param actionEvent   Action Event.
     * @throws IOException  IOException  If an input or output.
     */
    public void handleButtonAction3(javafx.event.ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../view/fxml/ChairPage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method changes scene to Table page.
     * @param actionEvent   Action Event.
     * @throws IOException  IOException  If an input or output.
     */
    public void handleButtonAction4(javafx.event.ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../view/fxml/TablePage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method changes scene to Bed page.
     * @param actionEvent   Action Event.
     * @throws IOException  IOException  If an input or output.
     */
    public void handleButtonAction5(javafx.event.ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../view/fxml/BedPage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method changes scene to Wardrobe page.
     * @param actionEvent   Action Event.
     * @throws IOException  IOException  If an input or output.
     */
    public void handleButtonAction6(javafx.event.ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../view/fxml/WardrobePage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
