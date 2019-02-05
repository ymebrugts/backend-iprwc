package nl.iprwc.resources;

import io.dropwizard.hibernate.UnitOfWork;
import nl.iprwc.auth.PasswordManager;
import nl.iprwc.model.Account;
import nl.iprwc.persistence.AccountDAO;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

public class LoginResource {

    AccountDAO accountDAO;

    LoginResource(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @POST
    @Path("/{email}")
    @UnitOfWork
    public Account login(@PathParam("email") String email,
                         String password) {
        Account account = accountDAO.findByEmail(email);
        if (account != null) {
            boolean validPassword = PasswordManager.getInstance().verifyHash(password, account.getPassword());
            if (validPassword) {
                accountDAO.evictAccount(account);
                account.setPassword(null);
                return account;
            }
        }
        throw new NotAuthorizedException("UNAUTHORIZED");
    }
}
