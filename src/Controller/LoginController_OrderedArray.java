package Controller;

/**
 * Created by usa on 7/10/2016.
 */

import Exception.IndexOutOfBoundException;
import Model.UserDB_OrderedArray;
import View.SignUpJavaFXView;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import View.HospitalListJavaFXView;

import java.io.IOException;
import Model.UserDB_OrderedArray;

public class LoginController_OrderedArray {
    @FXML
    TextField uname;
    @FXML
    PasswordField pw;
    boolean exist=false;

    public void Authenticate()  {


        for (int i = 0; i < UserDB_OrderedArray.getUsers().size(); i++) {
            if (uname.getText().equals(UserDB_OrderedArray.getUsers().getE(i).getUserName()) && pw.getText().equals(UserDB_OrderedArray.getUsers().getE(i).getPassWord())) {
                System.out.println("Welcome  " + uname.getText());
                try {
                    new HospitalListJavaFXView();
                } catch (IOException e) {
                    System.err.println("Error opening hospital list view!");
                    e.printStackTrace();
                }
                exist = true;


            } else {
                System.out.println("Fail Authentication");
            }
        }


    }


    public void openSignUpView() throws Exception {
        new SignUpJavaFXView();
    }
}
