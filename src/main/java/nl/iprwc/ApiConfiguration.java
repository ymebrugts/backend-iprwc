package nl.iprwc;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import nl.iprwc.persistence.AccountDAO;
import nl.iprwc.persistence.ProductDAO;
import nl.iprwc.resources.ProductResource;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class ApiConfiguration extends Configuration {

    @Valid
    @NotNull
    @JsonProperty("database")
    private DataSourceFactory database = new DataSourceFactory();

    public DataSourceFactory getDataSourceFactory() {
        return database;
    }

}
