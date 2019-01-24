package nl.iprwc;


import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import nl.iprwc.model.Account;
import nl.iprwc.model.Product;
import nl.iprwc.persistence.AccountDAO;
import nl.iprwc.persistence.ProductDAO;
import nl.iprwc.resources.AccountResource;
import nl.iprwc.resources.ProductResource;
import nl.iprwc.util.DatabaseConnection;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

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
        bootstrap.addBundle(hibernateBundle);
    }

    @Override
    public void run(final ApiConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application

        final ProductDAO productDAO = new ProductDAO(hibernateBundle.getSessionFactory());
        final AccountDAO accountDAO = new AccountDAO(hibernateBundle.getSessionFactory());
        environment.jersey().register(new ProductResource(productDAO));
        environment.jersey().register(new AccountResource(accountDAO));
//        databaseConnection = configuration.getDatabaseConnection();

//        environment.jersey().register(configuration.getProductResource());
        configureCors(environment);

//        environment.jersey().register(configuration.getLocationDaoResource());
//        environment.jersey().register(configuration.getAccountDaoResource());
//        environment.jersey().register(configuration.getBasketDaoResource());
    }


    private void configureCors(Environment environment) {
        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        // Configure CORS parameters
        cors.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
        cors.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM, "X-Requested-With,Content-Type,Accept,Origin,Authorization");
        cors.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "OPTIONS,GET,PUT,POST,DELETE,HEAD");
        cors.setInitParameter(CrossOriginFilter.ALLOW_CREDENTIALS_PARAM, "true");

        // Add URL mapping
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

    }


    /**
     * Hibernate bundle.
     */
    private final HibernateBundle<ApiConfiguration> hibernateBundle
            = new HibernateBundle<ApiConfiguration>(Account.class, Product.class) {

        @Override
        public DataSourceFactory getDataSourceFactory(ApiConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };





}
