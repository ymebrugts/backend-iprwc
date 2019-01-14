package nl.iprwc.resources;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonView;
import nl.iprwc.persistence.*;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import nl.iprwc.model.Item;
import nl.iprwc.service.ItemService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/item")
@Produces(MediaType.APPLICATION_JSON)
public class ItemResource {

    @JsonProperty("ItemDao")
    private ItemService itemService;

    private List<Item> itemsList;

    @Inject
    public ItemResource(ItemService itemService)
    {
        this.itemService = itemService;
    }

    @GET
    @Timed
    @Path("/all")
    public List<Item> readAll () {
        return itemsList;
    }

    @GET
    @Timed
    @Path("/hello")
    public String Hello () {
        return "Hello";
    }

    @GET
    @Timed
    @Path("/{id}")
    public Item retrieve(@PathParam("id") int id) {
        return itemService.getItemFromId(id);
    }

}
