package controller;

import model.account.Admin;
import model.account.Customer;
import model.Main;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class is a controller of "AdminPage.fxml".
 */
public class ControllerAdmin {

    @FXML
    public TextField textField;

    @FXML
    public PasswordField passField;

    @FXML
    public Button backBtn;

    @FXML
    public Button loginBtn;

    @FXML
    public Button alertBtn;

    Parent root;

    /**
     * This method change scene to Main Page.
     * @param actionEvent Action Event
     * @throws IOException IOException  If an input or output.
     */
    public void handleButtonAction1(javafx.event.ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../view/fxml/MainPage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    /**
     * This method controls input from the user and compares this input with
     * login names and passwords from the array list of customers. It compares
     * also with admin information.
     * If user enters login name and password of admin, it will change scene to Admin page.
     * If user enters login name and password of some customer, it will change scene that
     * will display customer's shopping cart.
     * If input won't be correct, alert box will be displayed.
     * @param actionEvent Action Event
     * @throws IOException IOException  If an input or output.
     */

    public void handleButtonAction2(javafx.event.ActionEvent actionEvent) throws Exception {
        Admin admin = Admin.createAdmin();
        for (Customer c : Main.customers) {
            if (c.getLoginName().equals(textField.getText())) {
                if (c.getPassword().equals(passField.getText())) {
                    c.print = true;
                    root = FXMLLoader.load(getClass().getResource("../view/fxml/ShowShoppingCart.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                    return;
                } else {
                    Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/AlertBox2.fxml"));
                    Scene scene1 = new Scene(root);
                    Stage stage1 = new Stage();
                    stage1.setResizable(false);
                    stage1.setScene(scene1);
                    stage1.showAndWait();
                    return;
                }
            }
        }

        if (admin.confirmName(textField.getText())) {
            if (admin.confirmPassword(passField.getText())) {
                root = FXMLLoader.load(getClass().getResource("../view/fxml/ListOfCustomersPage.fxml"));
                Scene scene1 = new Scene(root);
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.setScene(scene1);
                stage.show();
            } else {
                Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/AlertBox2.fxml"));
                Scene scene1 = new Scene(root);
                Stage stage1 = new Stage();
                stage1.setResizable(false);
                stage1.setScene(scene1);
                stage1.showAndWait();
            }
        } else {
            //using my own handlers for creating a alert box if the name is not correct.
            class Allert extends Application {
                @Override
                public void start(Stage primaryStage){
                    primaryStage.setResizable(false);
                    AnchorPane pane = new AnchorPane();
                    Button button = new Button("Späť");
                    button.setLayoutX(125);
                    button.setLayoutY(100);
                    //handler
                    button.setOnAction(event -> primaryStage.close() );

                    Label label = new Label("Zadali ste nesprávne meno.");
                    label.setFont(new Font("Arial", 20));
                    label.setLayoutX(30);
                    label.setLayoutY(45);

                    pane.getChildren().addAll(label,button);

                    Scene scene = new Scene(pane, 300, 200);
                    primaryStage.setScene(scene);
                    primaryStage.showAndWait();
                }
            }
            Allert allert = new Allert();
            allert.start(new Stage());
        }
    }

    /**
     * Method for closing alert box.
     */
    public void back_toAdmin(){
        Stage stage = (Stage) alertBtn.getScene().getWindow();
        stage.close();
    }
}
