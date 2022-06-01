package controller;

import model.furniture.*;
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
 * This class is a controller of "BedPage.fxml"
 */
public class ControllerBed {
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
    private Label ebenBedPrize;
    @FXML
    private Label oakBedPrize;
    @FXML
    private Label spruceBedPrize;
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

    Parent root;

    /**
     * Method displays information about products.
     */
    @FXML
    private void initialize(){
        ebenBedPrize.setText("CENA: " + (Bed.prizeOfProduction + Bed.countOfPlanks * Eben.prize) + " €");
        spruceBedPrize.setText("CENA: " + (Bed.prizeOfProduction + Bed.countOfPlanks * Spruce.prize) + " €");
        oakBedPrize.setText("CENA: " + (Bed.prizeOfProduction + Bed.countOfPlanks * Oak.prize) + " €");
        ebenToCart.setVisible(false);
        spruceToCart.setVisible(false);
        oakToCart.setVisible(false);
        soldEben.setVisible(false);
        soldSpruce.setVisible(false);
        soldOak.setVisible(false);
        checkWarehouse(new Bed(), 0);
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
     * This method changes scene to Shopping Cart page.
     * @param actionEvent   Action Event.
     * @throws IOException  If an input or output.
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
     * @throws IOException  If an input or output.
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
     * @throws IOException  If an input or output.
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
     * @throws IOException  If an input or output.
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
     * @throws IOException  If an input or output.
     */
    public void handleButtonAction6(javafx.event.ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../view/fxml/WardrobePage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method refreshes amount of each type of furniture that is in warehouse.
     * @param f     Type of furniture.
     * @param flag  Auxiliary variable
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
    public void buyEbenBed() {
        if(countEben.getText().equals("Počet na sklade: 0")) {
            showEmptyCart(soldEben);
        }else{
            Main.customers.get(Main.countOfCustomers - 1).getShoppingCart().addToCart(new Bed(), new Eben());
            Main.customers.get(Main.countOfCustomers - 1).countOfItems++;
            showEmptyCart(ebenToCart);
            increaseCountOfCart();
            countEben.setText("Počet na sklade: " + (new Bed()).returnCount(new Eben(), 1));
        }
    }

    /**
     * This method is execute after clicking on the button "oaktoCart". It adds
     * required furniture to the shopping cart.
     * If amount of this furniture is 0, it display label for 2 seconds.
     */
    public void buyOakBed() {
        if(countOak.getText().equals("Počet na sklade: 0")) {
            showEmptyCart(soldOak);
        }else {
            Main.customers.get(Main.countOfCustomers - 1).getShoppingCart().addToCart(new Bed(), new Oak());
            Main.customers.get(Main.countOfCustomers - 1).countOfItems++;
            showEmptyCart(oakToCart);
            increaseCountOfCart();
            countOak.setText("Počet na sklade: " + (new Bed()).returnCount(new Oak(), 1));
        }
    }

    /**
     * This method is execute after clicking on the button "spruceToCart". It adds
     * required furniture to the shopping cart.
     * If amount of this furniture is 0, it display label for 2 seconds.
     */
    public void buySpruceBed() {
        if(countSpruce.getText().equals("Počet na sklade: 0")) {
            showEmptyCart(soldSpruce);
        }else {
            Main.customers.get(Main.countOfCustomers - 1).getShoppingCart().addToCart(new Bed(), new Spruce());
            Main.customers.get(Main.countOfCustomers - 1).countOfItems++;
            showEmptyCart(spruceToCart);
            increaseCountOfCart();
            countSpruce.setText("Počet na sklade: " + (new Bed()).returnCount(new Spruce(), 1));
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
                Duration.seconds(1.5)
        );
        visible.setOnFinished(
                event -> label.setVisible(false)
        );
        visible.play();
    }
}
