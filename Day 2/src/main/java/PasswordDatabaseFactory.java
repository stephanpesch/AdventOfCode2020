import domain.Password;
import domain.PasswordDatabase;
import domain.Policy;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class PasswordDatabaseFactory {
    private PasswordDatabaseFactory() {}

    public static PasswordDatabase loadFromFile(String name) {
        ArrayList<Password> passwords = new ArrayList<>();

        try (Scanner scanner = new Scanner(Paths.get(name))) {
            while (scanner.hasNext()) {
                String[] line = scanner.nextLine().split("-|\\s|(:\\s)");
                passwords.add(new Password(line[3],
                        new Policy(Integer.parseInt(line[0]), Integer.parseInt(line[1]), line[2].charAt(0))));
            }
            return new PasswordDatabase(passwords);
        } catch (IOException e) {
            e.printStackTrace();
            return new PasswordDatabase();
        }
    }
}
