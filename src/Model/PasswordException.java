package Model;

/**
 * Created by usa on 4/4/2016.
 */
public class PasswordException extends Exception {
    private String password;

    public PasswordException(String password) {
        super("Invalid password <TRY AGAIN>");
        this.password = password;
    }
}

