package domain;

public class Password {

    private Policy policy;
    private String password;

    public Password(String password, Policy policy) {
        this.password = password;
        this.policy = policy;
    }

    public boolean isValid() {
        return policy.isValidPassword(password);
    }
}
