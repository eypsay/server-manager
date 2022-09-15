package sayilir.coder.server.manager.Utulities;

import lombok.AllArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EmailCheck {
    String regex = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,18}$";

    public boolean checkEmail(String email) {

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        if (m.matches()) return true;
        else return false;

    }

}
