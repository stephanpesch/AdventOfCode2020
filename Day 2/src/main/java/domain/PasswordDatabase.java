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

    public long amountOfValid() {
        return passwords.stream().filter(Password::isValid).count();
    }
}
