package nl.iprwc.resources;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.auth.Auth;
import io.dropwizard.hibernate.UnitOfWork;
import nl.iprwc.auth.AuthChecker;
import nl.iprwc.auth.AuthManager;
import nl.iprwc.model.Account;
import nl.iprwc.model.Deliver;
import nl.iprwc.persistence.DeliverDAO;
import org.hibernate.annotations.DynamicInsert;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Path("/delivery")
@Produces(MediaType.APPLICATION_JSON)
public class DeliverResource {

    private DeliverDAO deliverDAO;

    public DeliverResource(DeliverDAO deliverDAO) {
        this.deliverDAO = deliverDAO;
    }

    @GET
    @UnitOfWork
    public List<Deliver> getAllDelivers() {
        return deliverDAO.findAll();
    }

    /*
    @GET
    @Path("/{id}")
    @UnitOfWork
    public Deliver get(@PathParam("id") int id) {
        return deliverDAO.findById(id);
    }
    */

    @POST
    @UnitOfWork
    public List<Deliver> add(@Auth Optional<Account> account,
                             @Valid List<Deliver> deliveries) {
        for (Deliver d : deliveries) {
            if (!AuthChecker.goodUser(account, d.getAccountEmail())) {
                throw new NotAuthorizedException("");
            }
        }
        List<Deliver> newDeliveries = deliverDAO.merge(deliveries);
        return newDeliveries;
    }

    /*
    @PUT
    @Path("/{id}")
    @UnitOfWork
    public Deliver update(@PathParam("id") int id, @Valid Deliver deliver) {
        deliver = deliverDAO.findById(id);
        deliverDAO.update(deliver);
        return deliver;
    }
    */

    /*
    @DELETE
    @Path("/{id}")
    @UnitOfWork
    public void delete(@PathParam("id") int id) {
        deliverDAO.delete(deliverDAO.findById(id));
    }
    */
}


