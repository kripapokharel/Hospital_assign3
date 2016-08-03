package Model;

/**
 * Created by usa on 4/4/2016.
 */
public class EmailException extends Exception {
    private String email;


    //InputException constructor
    public EmailException(String email) {
        super("Invalid email");
        this.email = email;
    }

    @Override
    public String toString() {
        return "Follow the email format [_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@ \\\"mail(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$\")";
    }


    //returns email address
    public String getEmail() {
        return email;
    }
}








