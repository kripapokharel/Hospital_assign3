package View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * Created by kripa on 7/3/2016.
 */
public class WelcomeJavaFXView {
    public WelcomeJavaFXView() throws IOException {
        Stage welcomeStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
        welcomeStage.setTitle("Welcome page");
        welcomeStage.setScene(new Scene(root, 500, 600));
        welcomeStage.show();


    }
}
