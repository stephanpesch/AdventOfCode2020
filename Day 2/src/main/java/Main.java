import domain.PasswordDatabase;

public class Main {
    public static void main(String[] args) {
        PasswordDatabase database = PasswordDatabaseFactory.loadFromFile("input");

        // Solved it, maybe better possible
        System.out.println(database.size());
    }
}
