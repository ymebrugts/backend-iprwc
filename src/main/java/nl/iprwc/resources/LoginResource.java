package nl.iprwc.resources;

import io.dropwizard.hibernate.UnitOfWork;
import nl.iprwc.auth.PasswordManager;
import nl.iprwc.model.Account;
import nl.iprwc.persistence.AccountDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
public class LoginResource {

    AccountDAO accountDAO;

    public LoginResource(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @POST
    @Path("/{email}")
    @UnitOfWork
    public Account login(@PathParam("email") String email,
                         String password) {
        Account account = accountDAO.findByEmail(email);
        System.out.println(account.toString());
        System.out.println("password:" + password);
        if (account != null) {
            boolean validPassword = PasswordManager.getInstance().verifyHash(password, account.getPassword());
            if (validPassword) {
                System.out.println("Password is valid nigga");
                accountDAO.evictAccount(account);
                account.setPassword(null);
                return account;
            } else {
                System.out.println("Password is INVALID nigga");
            }
        }
        throw new NotAuthorizedException("UNAUTHORIZED");
    }
}
