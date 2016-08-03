package View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by kp26842 on 6/29/2016.
 */
public class SignUpJavaFXView {
    private static Stage signUpStage = new Stage();

    public static void setSignUpStage(Stage signUpStage) {
        SignUpJavaFXView.signUpStage = signUpStage;
    }

    public static Stage getSignUpStage() {
        return signUpStage;
    }

    public SignUpJavaFXView() throws IOException {
        Stage signUpStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        signUpStage.setTitle("Sign Up page");
        Scene signUpScene = new Scene(root, 500, 700);
        //signUpScene.getStylesheets().add("StyleSheets.css");
        signUpStage.setScene(signUpScene);
        signUpStage.show();
    }

}


