package controller;

import model.Main;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.*;


/**
 * This class is a controller of "CustomerPage.fxml".
 */
public class ControllerCustomer {
    @FXML
    public TextField textName;
    @FXML
    public Button confirmBtn;
    @FXML
    public TextField textLastName;
    @FXML
    public TextField textNumber;
    @FXML
    public TextField textEmail;
    @FXML
    public TextField textCity;
    @FXML
    public TextField textStreet;
    @FXML
    public PasswordField password;
    @FXML
    public PasswordField password2;
    @FXML
    public TextField loginName;
    @FXML
    public Button backBtn;
    @FXML
    private Label exception;

    Parent root;

    @FXML
    public void initialize(){
        exception.setVisible(false);
    }

    /**
     * Method that displays label for 1.5 sec.
     * @param label Label that has to be displayed.
     */
    public void showLabel(Label label){
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
     * Method changes scene to Shopping cart page.
     * @param actionEvent Action Event
     * @throws IOException  IOException  If an input or output.
     */
    public void handleButtonAction1(javafx.event.ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../view/fxml/ShoppingCartPage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Method changes scene to Shopping cart page.
     * @param actionEvent Action Event
     * @throws IOException  IOException  If an input or output.
     * @throws EmptyFieldException If textfield is empty.
     */
    public void handleButtonAction2(ActionEvent actionEvent) throws IOException, EmptyFieldException{
        try {
            textFieldsAction();
            try {
                checkPassword();
                root = FXMLLoader.load(getClass().getResource("../view/fxml/MainPage.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (NotSamePasswordException e){
                exception.setText("Heslá sa nezhodujú.");
                showLabel(exception);
            }
        } catch (EmptyFieldException e){
            exception.setText(e.text);
            showLabel(exception);
        } catch(UsedName e){
            exception.setText(e.text);
            showLabel(exception);
        }
    }

    /**
     * This method reads text from text fields. After successful reading array list of
     * customer will be serialized.
     * @throws EmptyFieldException  Empty field exception means that user does not
     * fulfill every text field (My own exception).
     * @throws UsedName Used name exception means that user name is already used
     * (my own exception).
     */
    public void textFieldsAction() throws EmptyFieldException, UsedName{
        if(textName.getText().equals(""))
            throw new EmptyFieldException("Zadajte svoje meno.");
        else
            Main.customers.get(Main.countOfCustomers -1).setName(textName.getText());

        if(textLastName.getText().equals(""))
            throw new EmptyFieldException("Zadajte svoje priezvisko.");
        else
            Main.customers.get(Main.countOfCustomers -1).setLastName(textLastName.getText());

        if(textNumber.getText().equals(""))
            throw new EmptyFieldException("Zadajte svoje číslo.");
        else
            Main.customers.get(Main.countOfCustomers -1).setPhoneNumber(textNumber.getText());


        if(textEmail.getText().equals(""))
            throw new EmptyFieldException("Zadajte svoj email.");
        else
            Main.customers.get(Main.countOfCustomers -1).setEmail(textEmail.getText());

        Main.customers.get(Main.countOfCustomers -1).createAddress();

        if(textCity.getText().equals(""))
            throw new EmptyFieldException("Zadajte mesto bydliska.");
        else
            Main.customers.get(Main.countOfCustomers -1).getAddress().setCity(textCity.getText());

        if(textStreet.getText().equals(""))
            throw new EmptyFieldException("Zadajte ulicu bydliska.");
        else
            Main.customers.get(Main.countOfCustomers -1).getAddress().setStreet(textStreet.getText());

        if(password.getText().equals(""))
            throw new EmptyFieldException("Zadajte svoje heslo.");

        if(password2.getText().equals(""))
            throw new EmptyFieldException("Potvrďte svoje heslo.");
        else
            Main.customers.get(Main.countOfCustomers - 1).setPassword(password2.getText());

        if(loginName.getText().equals("")) {
            throw new EmptyFieldException("Zadajte svoje používateľské meno.");
        }else {
            if(Main.countOfCustomers != 1) {
                for (int i = 0 ; i < Main.countOfCustomers - 1 ; i++) {
                    if (Main.customers.get(i).getLoginName().equals(loginName.getText())) {
                        throw new UsedName("Zadané meno už existuje.");
                    }
                }
            }
            Main.customers.get(Main.countOfCustomers - 1).setLoginName(loginName.getText());
        }

        //Serialization
        try {
            FileOutputStream file = new FileOutputStream("src/model/SerializableFile.txt");
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(Main.customers);
            file.close();
        }
        catch (IOException e){
            System.out.println("Exception caught.");
        }
    }

    /**
     * Method checks if user enters same confirm password.
     * @throws NotSamePasswordException Not same Password exception means
     * that the user does not enter same passwords (my own exception).
     */
    public void checkPassword() throws NotSamePasswordException{
        if(!password.getText().equals(password2.getText())){
            throw new NotSamePasswordException();
        }
    }
}
