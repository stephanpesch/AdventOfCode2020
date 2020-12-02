package domain;

public class Policy {

    private int from;
    private int to;
    private char character;

    public Policy(int from, int to, char character) {
        this.from = from;
        this.to = to;
        this.character = character;
    }

    public boolean isValidPassword(String password) {
        int charCount = 0;
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) == character) {
                charCount++;
            }
        }
        return charCount >= from && charCount <= to;
    }
}
