package View;

import Model.User;
import Model.UserDB_OrderedArray;
import Model.UserIO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Utils.ArrayOrderedList;

import java.io.IOException;


public class LogInJavaFXView extends Application {

    public static void loadUserDB() {

        try {
            // UserDB.setUsers((ArrayList<User>) UserIO.readUsers());
            UserDB_OrderedArray.setUsers((ArrayOrderedList<User>) UserIO.readUsers());

        } catch (IOException e) {
            System.out.println("Fail to open");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found exception");
        }
    }

    public static void main(String[] args) {
        loadUserDB();
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 500, 450));
        primaryStage.show();
    }
}
