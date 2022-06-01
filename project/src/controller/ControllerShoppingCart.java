package controller;

import model.Main;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;

/**
 * This class is a controller of "ShoppingCartPage.fxml".
 */
public class ControllerShoppingCart {
    @FXML
    public Button backButton;
    @FXML
    public Button next;
    @FXML
    private TextArea listOfItems;
    @FXML
    private TextArea prize;
    @FXML
    private Label empty;

    Parent root;

    /**
     * This method displays labels after loading this scene.
     */
    @FXML
    private void initialize(){
        empty.setVisible(false);
        listOfItems.setText(Main.customers.get(Main.countOfCustomers - 1).getShoppingCart().getItemsOfCart());
        //prize.setText("Celková suma: " + Integer.toString(totalPrize.updateObser((Main.customers.get(Main.countOfCustomers - 1).getShoppingCart()))) + " €");
        prize.setText("Celková suma: " + Integer.toString(Main.customers.get(Main.countOfCustomers - 1).getShoppingCart().Notify()));
    }

    /**
     * This method changes scene to Shop menu page.
     * @param actionEvent   Action Event.
     * @throws IOException  IOException  If an input or output.
     */
    public void handleButtonAction1(javafx.event.ActionEvent actionEvent) throws IOException {
        listOfItems.setText("");
        root = FXMLLoader.load(getClass().getResource("../view/fxml/ShopMenu.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method displays label for 1.5 sec.
     * @param label Label that has to be displayed.
     */
    public void showEmptyCart(Label label){
        label.setVisible(true);
        PauseTransition visible = new PauseTransition(
                Duration.seconds(3)
        );
        visible.setOnFinished(
                event -> label.setVisible(false)
        );
        visible.play();
    }

    /**
     * This method changes scene to Customer page.
     * @param actionEvent   Action Event.
     * @throws IOException  IOException  If an input or output.
     */
    public void handleButtonAction2(javafx.event.ActionEvent actionEvent) throws IOException {
        if(Main.customers.get(Main.countOfCustomers - 1).getShoppingCart().Notify() == 0){
            showEmptyCart(empty);
        }else {
            root = FXMLLoader.load(getClass().getResource("../view/fxml/CustomerPage.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }
}
