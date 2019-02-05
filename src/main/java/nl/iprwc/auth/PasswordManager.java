package nl.iprwc.auth;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordManager {

    private final int ROUNDS = 10;

    private static PasswordManager instance = new PasswordManager();
    private PasswordManager() { }
    public static PasswordManager getInstance() { return instance; }

    public String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(ROUNDS));
    }

    public boolean verifyHash(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }

}
