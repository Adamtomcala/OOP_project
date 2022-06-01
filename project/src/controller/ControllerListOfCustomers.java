package controller;


import model.account.ShoppingCart;
import model.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.*;

@FunctionalInterface
interface Show{
    void show() throws IOException;
}

/**
 * This class is a controller of "ListOfCustomersPage.fxml.
 * "
 */
public class ControllerListOfCustomers {
    @FXML
    private TextArea listOfTimeProduction;
    @FXML
    private TextArea listOfPrize;
    @FXML
    private TextArea listOfAddress;
    @FXML
    private TextArea listOfCustomers;
    @FXML
    private Button spat;
    @FXML
    private Button warehouse;

    Parent root;

    /**
     * This method loads information about customers from array list of customers
     * and prints it on the screen. There is used lambda expression for implementing
     * interface.
     * @throws IOException IOException  If an input or output.
     */
    @FXML
    private void initialize() throws IOException{
        Show show = () -> {
            String list = "";
            for(int i = 0; i < Main.countOfCustomers; i++){
                list = list.concat(Main.customers.get(i).getName()+ " " + Main.customers.get(i).getLastName() + "\n");
            }
            listOfCustomers.setText(list);

            list = "";
            for(int i = 0; i < Main.countOfCustomers; i++){
                ShoppingCart cart = new ShoppingCart();
                cart = Main.customers.get(i).getShoppingCart();
                list = list.concat(String.valueOf(Main.factory.createFurniture(cart)) + " dní\n");
            }
            listOfTimeProduction.setText(list);

            list = "";
            for(int i = 0; i < Main.countOfCustomers; i++){
                ShoppingCart cart = new ShoppingCart();
                cart = Main.customers.get(i).getShoppingCart();
                list = list.concat(String.valueOf(Main.factory.createFinalPrize(cart)) + " €\n");
            }
            listOfPrize.setText(list);

            list = "";

            for(int i = 0; i < Main.countOfCustomers; i++){
                list = list.concat(Main.customers.get(i).getAddress().getCity() + " "
                        +  Main.customers.get(i).getAddress().getStreet() + "\n");
            }
            listOfAddress.setText(list);
            System.out.println(Main.countOfCustomers);
        };
        show.show();
    }

    /**
     * This method changes scene to Admin page.
     * @param actionEvent   Action Event
     * @throws IOException  IOException If an input or output.
     */
    public void Back(javafx.event.ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../view/fxml/AdminPage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method changes scene to Warehouse page.
     * @param actionEvent  Action event
     * @throws IOException IOException  If an input or output.
     */
    public void goToWarehouse(javafx.event.ActionEvent actionEvent) throws IOException{
        root = FXMLLoader.load(getClass().getResource("../view/fxml/Warehouse.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
