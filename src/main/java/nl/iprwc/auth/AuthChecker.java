package nl.iprwc.auth;

import nl.iprwc.model.Account;

import java.util.Optional;

public class AuthChecker {

    public static boolean goodUser(Optional<Account> account, String email) {
        return (account.isPresent() && account.get().getEmail().equals(email));
    }

    public static boolean goodAdmin(Optional<Account> account) {
        return (account.isPresent() && account.get().isAdmin());
    }
}
