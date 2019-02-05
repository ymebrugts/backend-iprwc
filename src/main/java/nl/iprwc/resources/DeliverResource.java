package nl.iprwc.resources;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.hibernate.UnitOfWork;
import nl.iprwc.model.Deliver;
import nl.iprwc.persistence.DeliverDAO;
import org.hibernate.annotations.DynamicInsert;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/deliver")
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

    @GET
    @Path("/{id}")
    @UnitOfWork
    public Deliver get(@PathParam("id") int id) {
        return deliverDAO.findById(id);
    }

    @POST
    @UnitOfWork
    public Deliver add(@Valid Deliver deliver) {
        Deliver newDeliver = deliverDAO.insert(deliver);
        return newDeliver;
    }

    @PUT
    @Path("/{id}")
    @UnitOfWork
    public Deliver update(@PathParam("id") int id, @Valid Deliver deliver) {
        deliver = deliverDAO.findById(id);
        deliverDAO.update(deliver);
        return deliver;
    }

    @DELETE
    @Path("/{id}")
    @UnitOfWork
    public void delete(@PathParam("id") int id) {
        deliverDAO.delete(deliverDAO.findById(id));
    }
}


