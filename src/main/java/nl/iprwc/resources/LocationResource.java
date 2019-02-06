package nl.iprwc.resources;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.auth.Auth;
import io.dropwizard.hibernate.UnitOfWork;
import nl.iprwc.auth.AuthChecker;
import nl.iprwc.model.Account;
import nl.iprwc.model.Location;
import nl.iprwc.persistence.LocationDAO;
import org.hibernate.annotations.DynamicInsert;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/location")
@Produces(MediaType.APPLICATION_JSON)
public class LocationResource {

    private LocationDAO locationDAO;

    public LocationResource(LocationDAO locationDAO) {
        this.locationDAO = locationDAO;
    }

    /*
    @GET
    @UnitOfWork
    public List<Location> getAllLocations() {
        return locationDAO.findAll();
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    public Location get(@PathParam("id") int id) {
        return locationDAO.findById(id);
    }
    */

    @POST
    @UnitOfWork
    public Location add(@Auth Optional<Account> account,
                        @Valid Location location) {
        if (!AuthChecker.goodUser(account, location.getAccountEmail())) {
            throw new NotAuthorizedException("");
        }
        Location newLocation = locationDAO.insert(location);
        return newLocation;
    }

    /*
    @PUT
    @Path("/{id}")
    @UnitOfWork
    public Location update(@PathParam("id") int id, @Valid Location location) {
        location = locationDAO.findById(id);
        locationDAO.update(location);
        return location;
    }

    @DELETE
    @Path("/{id}")
    @UnitOfWork
    public void delete(@PathParam("id") int id) {
        locationDAO.delete(locationDAO.findById(id));
    }
    */
}

