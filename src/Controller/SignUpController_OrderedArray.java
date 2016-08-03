package Controller;

import Exception.IndexOutOfBoundException;
import Model.User;
import Model.UserIO;
import View.SignUpJavaFXView;
import View.WelcomeJavaFXView;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

import java.io.File;
import java.io.IOException;
import Model.EmailException;
import Model.EmailValidator;
import Model.PasswordException;
import Model.PasswordValidator;
import Model.User;
import Model.UserDB_OrderedArray;


/**
 * Created by kp26842 on 6/29/2016.
 */
public class SignUpController_OrderedArray {
    @FXML
    TextField fname;
    @FXML
    TextField lname;
    @FXML
    TextField SSN;
    @FXML
    DatePicker date;
    @FXML
    TextField email;
    @FXML
    Label emptyFieldError;
    @FXML
    Button ClearButton;

    @FXML
    PasswordField pw;
    @FXML
    PasswordField cpw;
    @FXML
    Label pwformatError;
    @FXML
    Label validationError;
    @FXML
    Label emailFormatError;
    @FXML
    Label emailReuseError;

    public void signUp() throws EmailException, PasswordException, IndexOutOfBoundException, IOException {
        EmailValidator emV = new EmailValidator();
        PasswordValidator pwV = new PasswordValidator();


        /*Validating email for its required format and letting user use only the unique email address*/
        for (int i = 0; i < UserDB_OrderedArray.getUsers().size(); i++) {
            if (email.getText().equals(UserDB_OrderedArray.getUsers().getE(i).getUserName())) {
                emailReuseError.setVisible(true);
                email.setId("button");
            }

        }

        if (emV.validate(email.getText())) {
            emailFormatError.setVisible(false);
        } else {
            emailFormatError.setVisible(true);
            email.setId("button");
        }
        if (fname.getText() == null && lname.getText() == null && email.getText() == null && SSN.getText() == null && date.getAccessibleText() == null &&
                pw.getText() == null && cpw.getText() == null) {
            emptyFieldError.setVisible(true);
            email.setId("button");


        }


        if (pwV.validate(pw.getText())) {
            if (pw.getText().equals(cpw.getText())) {
                User user = new User(email.getText(), pw.getText());
                UserDB_OrderedArray.getUsers().add(user);
                try {
                    UserIO.writeUsers(UserDB_OrderedArray.getUsers());

                } catch (IOException e) {

                    System.out.println(e.getStackTrace());
                    System.err.println(UserDB_OrderedArray.getUsers());


                }
            } else {
            /*Password and Confirm Password do not match*/
                validationError.setVisible(true);
                /*Stylesheet Identifier #button is used*/
                pw.setId("button");

            }
        } else {
            pwformatError.setVisible(true);
            pw.setId("button");
        }
        new WelcomeJavaFXView();
    }

    public void clearText() {
        ClearButton.setId("button");
        email.clear();
        pw.clear();
        cpw.clear();
        validationError.setVisible(false);
        emailFormatError.setVisible(false);
        pwformatError.setVisible(false);
        emailReuseError.setVisible(false);
        emptyFieldError.setVisible(false);
        pw.setId("clearbutton");
        email.setId("clearbutton");
        ClearButton.setId("clearbutton");

    }

    public void openWelcomePage() throws Exception {

        new WelcomeJavaFXView();
    }

    public void createFileBrowser() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Browse picture");
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("TextFiles", "*.text"),
                new ExtensionFilter("Image Files", "*.jpg", "*.png"));
        File selectFile = fileChooser.showOpenDialog(SignUpJavaFXView.getSignUpStage());
        System.out.println(selectFile.getPath());


    }
}
