package Model;

/**
 * Created by usa on 4/4/2016.
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {

    /**
     * must contains one digit from 0-9
     * (?=.*[a-z])		#   must contains one lowercase characters
     * (?=.*[A-Z])		#   must contains one uppercase characters
     * (?=.*[@#$%])		#   must contains one special symbols in the list "@#$%"
     * .		#     match anything with previous condition checking
     * {6,20}	#        length at least 6 characters and maximum of 20
     * )			# End of group
     */

    private Pattern pattern;
    private Matcher matcher;

    private static final String PASSWORD_PATTERN =
            "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";

    public PasswordValidator() {
        pattern = Pattern.compile(PASSWORD_PATTERN);
    }


    public boolean validate(String password) throws PasswordException {

        matcher = pattern.matcher(password);
        return matcher.matches();

    }
}

