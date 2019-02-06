package nl.iprwc.auth;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;
import io.dropwizard.hibernate.UnitOfWork;
import nl.iprwc.model.Account;
import nl.iprwc.persistence.AccountDAO;

import java.util.Optional;

public class AuthManager implements Authenticator<BasicCredentials, Account> {

    private AccountDAO accountDAO;

    public AuthManager(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    @UnitOfWork
    public Optional<Account> authenticate(BasicCredentials credentials) throws AuthenticationException {
        String email = credentials.getUsername();
        String password = credentials.getPassword();
        Account account = accountDAO.findByEmail(email);
        if (account != null) {
            if (PasswordManager.getInstance().verifyHash(password, account.getPassword())) {
                return Optional.of(account);
            }
        }
        return Optional.empty();
    }

}
