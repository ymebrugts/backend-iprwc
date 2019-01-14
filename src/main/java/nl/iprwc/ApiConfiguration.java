package nl.iprwc;

import io.dropwizard.Configuration;
import nl.iprwc.persistence.ItemDao;
import nl.iprwc.resources.ItemResource;
import nl.iprwc.service.ItemService;
import nl.iprwc.util.DatabaseConnection;

public class ApiConfiguration extends Configuration {
    // TODO: implement service configuration
    DatabaseConnection database;
    ItemDao itemDao;
    ItemService itemService;

    public ApiConfiguration() {
        createDatabase();
        itemDao = new ItemDao(database);
        itemService = new ItemService(itemDao);
    }

    public void createDatabase() {
        database = new DatabaseConnection();
    }

    public DatabaseConnection getDatabaseConnection() {
        return database;
    }



    public ItemResource getItemResource() {
            return new ItemResource(itemService);
    }
}
