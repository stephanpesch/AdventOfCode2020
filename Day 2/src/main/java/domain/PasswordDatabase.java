package domain;

import java.util.ArrayList;
import java.util.List;

public class PasswordDatabase {
    private List<Password> passwords;

    public PasswordDatabase() {
        passwords = new ArrayList<>();
    }

    public PasswordDatabase(List<Password> passwords) {
        this.passwords = passwords;
    }

    public boolean add(Password password) {
        if (password.isValid()) {
            passwords.add(password);
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return passwords.size();
    }
}
