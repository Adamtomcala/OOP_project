package controller;

import model.account.Customer;
import model.account.TotalPrize;
import model.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * This class is a controller of "ShowShoppingCart.fxml".
 */
public class ControllerShowShoppingCart {
    @FXML
    public Button backButton;
    @FXML
    private TextArea listOfItems;
    @FXML
    private TextArea prize;

    Parent root;

    /**
     * This method displays content of customer's shopping cart, after
     * customer log in.
     */
    @FXML
    public void initialize(){
        TotalPrize totalPrize = new TotalPrize();
        for(Customer c : Main.customers){
            if(c.print){
                c.print = false;
                listOfItems.setText(c.getShoppingCart().getItemsOfCart());
                prize.setText("Celková suma: " + Integer.toString(totalPrize.updateObser((Main.customers.get(Main.countOfCustomers - 1).getShoppingCart()))) + " €");
                break;
            }
        }
    }

    /**
     * This method change scene to Main Page.
     * @param actionEvent Action Event
     * @throws IOException IOException  If an input or output.
     */
    public void handleAction(javafx.event.ActionEvent actionEvent) throws IOException{
        root = FXMLLoader.load(getClass().getResource("../view/fxml/MainPage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
