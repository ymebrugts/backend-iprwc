package nl.iprwc;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import nl.iprwc.persistence.ProductDAO;
import nl.iprwc.resources.ProductResource;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class ApiConfiguration extends Configuration {
    // TODO: implement service configuration
    ProductDAO productDao;
    @Valid
    @NotNull
    private DataSourceFactory dataSourceFactory = new DataSourceFactory();


    public ApiConfiguration() {

//        productDao = new ProductDAO(database);
//        productService = new ProductService(productDao);
    }

    /**
     * A getter for the database factory.
     *
     * @return An instance of database factory deserialized from the
     * configuration file passed as a command-line argument to the application.
     */
    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        return dataSourceFactory;
    }
}

//    public void createDatabase() {
//        database = new DatabaseConnection();
//    }

//    public DatabaseConnection getDatabaseConnection() {
//        return database;
//    }



//    public ProductResource getProductResource() {
//            return new ProductResource(productService);
//    }
//}
