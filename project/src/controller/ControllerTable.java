package controller;

import model.furniture.*;
import model.account.TotalPrize;
import model.Main;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

/**
 * This class is a controller of "TablePage.fxml".
 */
public class ControllerTable {
    @FXML
    public Button stolicky;
    @FXML
    public Button stoly;
    @FXML
    public Button postele;
    @FXML
    public Button skrine;
    @FXML
    public Button spat;
    @FXML
    public Button kosik;
    @FXML
    public Label oakToCart;
    @FXML
    public Label ebenToCart;
    @FXML
    public Label spruceToCart;
    @FXML
    public Label count;
    @FXML
    private Label ebenTablePrize;
    @FXML
    private Label oakTablePrize;
    @FXML
    private Label spruceTablePrize;
    @FXML
    private Label countOak;
    @FXML
    private Label countSpruce;
    @FXML
    private Label countEben;
    @FXML
    private Label soldOak;
    @FXML
    private Label soldSpruce;
    @FXML
    private Label soldEben;

    private TotalPrize prize = new TotalPrize();

    Parent root;

    /**
     * This method displays labels after loading the scene.
     */
    @FXML
    private void initialize(){
        ebenTablePrize.setText("CENA: " + (Table.prizeOfProduction + Table.countOfPlanks * Eben.prize) + " €");
        spruceTablePrize.setText("CENA: " + (Table.prizeOfProduction + Table.countOfPlanks * Spruce.prize) + " €");
        oakTablePrize.setText("CENA: " + (Table.prizeOfProduction + Table.countOfPlanks * Oak.prize) + " €");
        ebenToCart.setVisible(false);
        spruceToCart.setVisible(false);
        oakToCart.setVisible(false);
        soldEben.setVisible(false);
        soldOak.setVisible(false);
        soldSpruce.setVisible(false);
        checkWarehouse(new Table(), 0);
        increaseCountOfCart();
    }

    /**
     * This method changes scene to Main page.
     * If user clicked on the button that starts this method, customer will be removed
     * from the arraylist, because the user didn't buy anything.
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

    /**
     * This method refreshes amount of each type of model.furniture that is in warehouse.
     * @param f    Action Event.
     * @param flag Auxiliary variable.
     */
    public void checkWarehouse(Furniture f, int flag){
        countEben.setText("Počet na sklade: " + f.returnCount(new Eben(), flag));
        countOak.setText("Počet na sklade: " + f.returnCount(new Oak(), flag));
        countSpruce.setText("Počet na sklade: " + f.returnCount(new Spruce(), flag));
    }

    /**
     * This method is execute after clicking on the button "ebenToCart". It adds
     * required furniture to the shopping cart.
     * If amount of this furniture is 0, it display label for 2 seconds.
     */
    public void buyEbenTable(){
        if(countEben.getText().equals("Počet na sklade: 0")){
            showEmptyCart(soldEben);
        } else {
            countEben.setText("Počet na sklade: " + (new Table()).returnCount(new Eben(), 1));
            Main.customers.get(Main.countOfCustomers - 1).getShoppingCart().addToCart(new Table(), new Eben());
            Main.customers.get(Main.countOfCustomers - 1).countOfItems++;
            showEmptyCart(ebenToCart);
            increaseCountOfCart();
        }
    }

    /**
     * This method is execute after clicking on the button "oakToCart". It adds
     * required furniture to the shopping cart.
     * If amount of this furniture is 0, it display label for 2 seconds.
     */
    public void buyOakTable(){
        if(countOak.getText().equals("Počet na sklade: 0")){
            showEmptyCart(soldOak);
        } else {
            countOak.setText("Počet na sklade: " + (new Table()).returnCount(new Oak(), 1));
            Main.customers.get(Main.countOfCustomers - 1).getShoppingCart().addToCart(new Table(), new Oak());
            Main.customers.get(Main.countOfCustomers - 1).countOfItems++;
            showEmptyCart(oakToCart);
            increaseCountOfCart();
        }
    }

    /**
     * This method is execute after clicking on the button "spruceToCart". It adds
     * required furniture to the shopping cart.
     * If amount of this furniture is 0, it display label for 2 seconds.
     */
    public void buySpruceTable(){
        if(countSpruce.getText().equals("Počet na sklade: 0")){
            showEmptyCart(soldSpruce);
        } else {
            countSpruce.setText("Počet na sklade: " + (new Table()).returnCount(new Spruce(), 1));
            Main.customers.get(Main.countOfCustomers - 1).getShoppingCart().addToCart(new Table(), new Spruce());
            Main.customers.get(Main.countOfCustomers - 1).countOfItems++;
            showEmptyCart(spruceToCart);
            increaseCountOfCart();
        }
    }

    /**
     * This methods refreshes label "count" which represents count of items in the cart.
     */
    public void increaseCountOfCart(){
        if(Main.customers.get(Main.countOfCustomers -1).getShoppingCart().furnitures.size() > 0)
            count.setText(Integer.toString(Main.customers.get(Main.countOfCustomers - 1).getShoppingCart().furnitures.size()));
    }

    /**
     * Function for displaying label for 1.5 sec.
     * @param label Label which has to be displayed.
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
}
