package nl.iprwc;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import nl.iprwc.util.DatabaseConnection;

//https://www.dropwizard.io/0.9.1/docs/getting-started.html
public class ApiApplication extends Application<ApiConfiguration> {

    private static DatabaseConnection databaseConnection;
    public static DatabaseConnection getDatabaseConnection() {
        return databaseConnection;
    }

    public static void main(final String[] args) throws Exception {
        new ApiApplication().run(args);
    }

    @Override
    public String getName() {
        return "Api";
    }

    @Override
    public void initialize(final Bootstrap<ApiConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final ApiConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        databaseConnection = configuration.getDatabaseConnection();
        databaseConnection.connect();
        environment.jersey().register(configuration.getItemResource());
//        environment.jersey().register(configuration.getLocationDaoResource());
//        environment.jersey().register(configuration.getAccountDaoResource());
//        environment.jersey().register(configuration.getBasketDaoResource());
    }

}
