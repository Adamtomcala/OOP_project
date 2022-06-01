package model;

import model.account.Customer;
import model.furniture.Factory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.*;
import java.util.ArrayList;


public class Main extends Application {
    public static Stage window;
    public static ArrayList<Customer> customers = new ArrayList<Customer>();    //arrayList of all customers
    public static int countOfCustomers = 0;
    public static Factory factory = new Factory();

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Výroba dreveného nábytku.");
        window.setResizable(false);
        BorderPane grid = (BorderPane) FXMLLoader.load(Main.class.getResource("../view/fxml/MainPage.fxml"));
        Scene scene = new Scene(grid,985,465);
        window.setScene(scene);
        window.show();

        //deserialization
        FileInputStream file = new FileInputStream("src/model/SerializableFile.txt");

        if(file.available() != 0) {
            ObjectInputStream in = new ObjectInputStream(file);
            try {
                Main.customers = (ArrayList<Customer>) in.readObject();
                for (Customer c : Main.customers) {
                    Main.countOfCustomers++;
                }
            } catch (EOFException exception) {
                System.out.println("Empty file exception.\n");
            } catch (IOException e) {
                System.out.println("IOException.\n");
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}