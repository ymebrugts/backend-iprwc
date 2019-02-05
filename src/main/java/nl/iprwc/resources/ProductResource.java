package nl.iprwc.resources;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.hibernate.UnitOfWork;
import nl.iprwc.model.Product;
import nl.iprwc.persistence.ProductDAO;
import org.hibernate.annotations.DynamicInsert;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {

    private ProductDAO productDAO;

    public ProductResource(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @GET
    @UnitOfWork
    public List<Product> getAllProducts() {
        return productDAO.findAll();
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    public Product get(@PathParam("id") int id) {
        return productDAO.findById(id);
    }

    @POST
    @UnitOfWork
    public Product add(@Valid Product product) {
        Product newProduct = productDAO.insert(product);
        return newProduct;
    }

    @PUT
    @Path("/{id}")
    @UnitOfWork
    public Product update(@PathParam("id") int id, @Valid Product product) {
        product = productDAO.findById(id);
        productDAO.update(product);
        return product;
    }

    @DELETE
    @Path("/{id}")
    @UnitOfWork
    public void delete(@PathParam("id") int id) {
        productDAO.delete(productDAO.findById(id));
    }
}
