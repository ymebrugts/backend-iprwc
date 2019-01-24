package nl.iprwc.resources;

import io.dropwizard.hibernate.UnitOfWork;
import nl.iprwc.model.Account;
import nl.iprwc.persistence.AccountDAO;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/account")
@Produces(MediaType.APPLICATION_JSON)
public class AccountResource {

    private AccountDAO accountDAO;



    public AccountResource(AccountDAO accountDAO)
    {
        this.accountDAO = accountDAO;
    }


    @GET
    @UnitOfWork
    public List<Account> getAllAccounts() {
        return accountDAO.findAll();
    }

    @GET
    @Path("/{email}")
    @UnitOfWork
    public Account get(@PathParam("email") String email) {
        return accountDAO.findByEmail(email);
    }

    @POST
    @UnitOfWork
    public Account add(@Valid Account account) {
        Account newAccount = accountDAO.insert(account);
        return newAccount;
    }

    @PUT
    @Path("/{email}")
    @UnitOfWork
    public Account update(@PathParam("email") String email, @Valid Account account) {
        account = accountDAO.findByEmail(email);
        accountDAO.update(account);
        return account;
    }

    @DELETE
    @Path("/{email}")
    @UnitOfWork
    public void delete(@PathParam("email") String email) {
        accountDAO.delete(accountDAO.findByEmail(email));
    }
}
